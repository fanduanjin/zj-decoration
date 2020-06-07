package cn.fan.sms;

import cn.fan.EnableRedisFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @Description
 * @Date 2020/4/28
 * @Create By admin
 */

@SpringBootApplication
@EnableJms
@EnableRedisFramework
public class SmsApp {
    public static void main(String[] args) {
        SpringApplication.run(SmsApp.class,args);
        try {
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
