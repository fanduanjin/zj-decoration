package cn.fan;

import cn.fan.cache.HashKeyGenerator;
import cn.fan.serializer.KryoRedisSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.annotation.ProxyCachingConfiguration;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Duration;

/**
 * @Description
 * @Date 2020/4/28
 * @Create By admin
 */

@Configuration
@EnableCaching
public class RedisFrameworkConfig {
    Logger LOGGER = LoggerFactory.getLogger(RedisFrameworkConfig.class);

/*    @Bean
    RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }*/

    @Bean
    KryoRedisSerializer kryoRedisSerializer(RedisTemplate redisTemplate) {
        //使用kryo 作为 redis 序列化
        KryoRedisSerializer kryoRedisSerializer = new KryoRedisSerializer<>(Object.class);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //redisTemplate.setDefaultSerializer(kryoRedisSerializer);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(kryoRedisSerializer);
        redisTemplate.setHashValueSerializer(kryoRedisSerializer);
        String kryoName = KryoRedisSerializer.class.getName();
        String stringName = StringRedisSerializer.class.getName();
        LOGGER.info("enable value serializer:" + kryoName);
        LOGGER.info("enable key serializer :" + stringName);
        LOGGER.info("enable hashkey serializer :" + stringName);
        LOGGER.info("enable hashvalue serializer:" + kryoName);
        return kryoRedisSerializer;
    }

    @Bean
    KeyGenerator keyGenerator(CacheInterceptor interceptor) {
        KeyGenerator keyGenerator=new HashKeyGenerator();
        interceptor.setKeyGenerator(keyGenerator);
        LOGGER.info("enable hashKeyGennerator");
        return keyGenerator;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        KryoRedisSerializer kryoRedisSerializer = new KryoRedisSerializer(Object.class);
        // 配置序列化（解决乱码的问题）,过期时间15分钟
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(15))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(kryoRedisSerializer));

        RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(config)
                .build();
        LOGGER.info("enable spring cache : redis cache");
        return cacheManager;
    }


}
