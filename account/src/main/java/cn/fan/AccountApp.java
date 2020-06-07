package cn.fan;

import cn.fan.framework.EnableWebFrameWork;
import com.github.tobato.fastdfs.FdfsClientConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Description
 * @Date 2020/4/21
 * @Create By admin
 */
@SpringBootApplication
@EnableJms
@EnableRedisHttpSession
@EnableRedisFramework
@Import(FdfsClientConfig.class)
@EnableWebFrameWork
public class AccountApp {
    public static void main(String[] args) {
        SpringApplication.run(AccountApp.class,args);
    }
}
