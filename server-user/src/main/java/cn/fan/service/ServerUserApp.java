package cn.fan.service;

import cn.fan.EnableRedisFramework;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @Description
 * @Date 2020/4/25
 * @Create By admin
 */

@SpringBootApplication
@EnableRedisFramework
public class ServerUserApp {
    private Logger logger=LoggerFactory.getLogger(ServerUserApp.class);
    public static void main(String[] args) {

        SpringApplication.run(ServerUserApp.class,args);
        try {
            System.in.read();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
