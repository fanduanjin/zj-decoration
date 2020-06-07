package cn.fan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Date 2020/4/24
 * @Create By admin
 */
@RestController
@RequestMapping("/sys/test")
public class SysController {
    @RequestMapping
    public Object test(HttpSession session){
        return session.getAttribute("test");
    }
}
