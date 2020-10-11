package cn.fan.controller;


import cn.fan.api.IUserService;
import cn.fan.core.amq.AmqRegistryConstans;
import cn.fan.core.constans.RegistryConstans;
import cn.fan.core.constans.WebSecurityConstans;
import cn.fan.core.regexp.RegexpConstans;
import cn.fan.core.web.HttpResult;

import cn.fan.framework.config.security.JwtToken;
import cn.fan.framework.config.security.SecurityUserDetail;
import cn.fan.model.user.User;
import cn.fan.vo.UserRegistryVo;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2020/4/21
 * @Create By admin
 */

@RestController
@Validated
@RequestMapping("api/account")
@CacheConfig(cacheNames = "user")
public class AccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtToken jwtTokenUtil;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    @Qualifier(AmqRegistryConstans.QUEUE_NAME_REGISTRY_CODE)
    ActiveMQQueue registryCodeQueue;


    @Reference
    private IUserService userService;

    @RequestMapping("login")
    HttpResult login(@NotBlank(message = "用户名不能为空") String username, @NotBlank(message = "密码不能为空") String password, HttpSession session) {
        String token = null;
        try {
            User user = userService.getUserByUserName(username);
            if (user == null) {
                return HttpResult.FAILD_AUTHNATICATION("用户不存在");
            }
            if (!passwordEncoder.matches(password, passwordEncoder.encode(user.getPassword()))) {
                return HttpResult.FAILD_AUTHNATICATION("密码不正确");
            }
            UserDetails userDetails = new SecurityUserDetail(user);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails.getUsername());
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
            return HttpResult.FAILD_AUTHNATICATION(e.getMessage());
        } catch (Exception exception) {
            LOGGER.error("登录异常:{}", exception.getLocalizedMessage());
            return HttpResult.FAILD_AUTHNATICATION(exception.getMessage());
        }
        HttpResult httpResult = HttpResult.SUCCESS_AUTHNTICATION();
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put("tokenHead", WebSecurityConstans.TOKEN_HEAD);
        map.put("token", token);
        httpResult.setData(map);
        session.setAttribute("test", username);
        return httpResult;
    }

    @GetMapping("sendRegistryCode")
    public HttpResult sendRegistryCode(@NotBlank(message = "手机号码不能为空") @Pattern(regexp = RegexpConstans.PHONENUMBER, message = "手机号码格式不正确") String phoneNumber) {
        jmsMessagingTemplate.convertAndSend(registryCodeQueue, phoneNumber);
        LOGGER.info("send:" + RegistryConstans.REGISTRY_VALIDATOR_CODE_KEY + phoneNumber);
        return HttpResult.SUCCESS_RESULT();
    }


    @PutMapping("registry")
    HttpResult registry(@RequestBody@Validated UserRegistryVo user) {

        if (userService.exists(user.getPhoneNumber(), user.getUserName())) {
            return HttpResult.FAILD_RESULT("用户名或手机号已被注册");
        }
        String code = (String) redisTemplate.opsForValue().get(RegistryConstans.REGISTRY_VALIDATOR_CODE_KEY + user.getPhoneNumber());
        if (code == null || !code.equals(user.getValidatorCode())) {
            //验证失败
            return HttpResult.FAILD_RESULT("验证码不正确!");
        }
        userService.insertUser(user);
        String token = jwtTokenUtil.generateToken(user.getUserName());
        Map<String, String> map = new HashMap<String, String>(2);
        map.put("tokenHead", WebSecurityConstans.TOKEN_HEAD);
        map.put("token", token);
        return HttpResult.SUCCESS_RESULT(map);
    }


}
