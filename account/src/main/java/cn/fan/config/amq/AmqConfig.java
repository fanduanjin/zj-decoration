package cn.fan.config.amq;

import cn.fan.core.amq.AmqRegistryConstans;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Date 2020/4/28
 * @Create By admin
 */
@Configuration
public class AmqConfig {
    @Bean(name = AmqRegistryConstans.QUEUE_NAME_REGISTRY_CODE)
    ActiveMQQueue registryCodeQueue (){
        return new ActiveMQQueue(AmqRegistryConstans.QUEUE_NAME_REGISTRY_CODE);
    }

}
