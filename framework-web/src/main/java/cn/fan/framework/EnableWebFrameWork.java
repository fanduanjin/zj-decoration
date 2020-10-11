package cn.fan.framework;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Administrator
 * @Description
 * @Date 2020/4/29
 * @Create By admin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan
public @interface EnableWebFrameWork {
}
