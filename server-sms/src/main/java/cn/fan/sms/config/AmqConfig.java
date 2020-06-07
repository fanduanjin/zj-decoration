package cn.fan.sms.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @Description
 * @Date 2020/5/2
 * @Create By admin
 */
@Configuration
public class AmqConfig {
    @Autowired
    private Environment env;

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(env.getProperty("spring.activemq.broker-url"));
        connectionFactory.setUserName(env.getProperty("spring.activemq.user"));
        connectionFactory.setPassword(env.getProperty("spring.activemq.password"));
        return connectionFactory;
    }


    @Bean
    JmsListenerContainerFactory jmsListenerContainerFactory() {
        SimpleJmsListenerContainerFactory jmsListenerContainerFactory = new SimpleJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        return jmsListenerContainerFactory;
    }


}
