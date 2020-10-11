package cn.fan.controller;

import cn.fan.api.IUserService;
import cn.fan.core.web.HttpResult;
import cn.fan.core.web.PageInfo;
import cn.fan.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Date 2020/5/5
 * @Create By admin
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping ("list")
    HttpResult list(int currentPage,int pageSize){
        PageInfo pageInfo=userService.getList(currentPage,pageSize);
        HttpResult httpResult= HttpResult.SUCCESS_RESULT(pageInfo);
        return httpResult;
    }

    @PutMapping
    HttpResult modify(User user){
        userService.update(user);
        return HttpResult.SUCCESS_RESULT();
    }

    @DeleteMapping
    HttpResult delete(int userId){
        userService.deleteUser(userId);
        return HttpResult.SUCCESS_RESULT();
    }


}
