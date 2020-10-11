package cn.fan;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fanduanjin
 * @Description
 * @Date 2020/6/10
 * @Create By admin
 */
@SpringBootApplication
@EnableDubboConfig
public class ServerGoodsApp {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ServerGoodsApp.class,args);
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

