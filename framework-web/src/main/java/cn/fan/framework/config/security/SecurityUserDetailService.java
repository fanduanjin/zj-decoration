package cn.fan.framework.config.security;


import cn.fan.api.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Date 2020/4/24
 * @Create By admin
 */

public class SecurityUserDetailService implements UserDetailsService {


    @Reference
    IUserService userService;


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return new SecurityUserDetail(userService.getUserByUserName(s));
    }
}
