package cn.fan;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description
 * @Date 2020/4/28
 * @Create By admin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisFrameworkConfig.class)
@EnableCaching
public @interface EnableRedisFramework {
}
