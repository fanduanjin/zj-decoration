package cn.fan;

import cn.fan.framework.EnableWebFrameWork;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Description
 * @Date 2020/4/24
 * @Create By admin
 */

@SpringBootApplication
@EnableRedisHttpSession
@EnableRedisFramework
@EnableWebFrameWork
public class MbgApp {
    public static void main(String[] args) {
        SpringApplication.run(MbgApp.class,args);
    }
}
