package cn.fan.service;

import cn.fan.EnableRedisFramework;
import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.io.IOException;

/**
 * @Description
 * @Date 2020/5/5
 * @Create By admin
 */
@SpringBootApplication
@EnableRedisFramework
@Import(FdfsClientConfig.class)
public class ServerCommonApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerCommonApp.class,args);
        try {
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
