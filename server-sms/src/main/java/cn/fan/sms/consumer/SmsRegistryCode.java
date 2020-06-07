package cn.fan.sms.consumer;

import cn.fan.core.amq.AmqRegistryConstans;
import cn.fan.core.constans.RegistryConstans;
import cn.fan.sms.util.alibabasms.SmsSendUtil;
import cn.hutool.core.util.RandomUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpoint;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import java.util.UUID;

/**
 * @Description
 * @Date 2020/4/28
 * @Create By admin
 */
@Component
public class SmsRegistryCode {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsRegistryCode.class);
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SmsSendUtil smsSendUtil;

    @JmsListener(destination = AmqRegistryConstans.QUEUE_NAME_REGISTRY_CODE)
    void receiveMessage(String phoneNumber) {
        //接受消息调用短信接口
        //发送成功保存在redis
        String key = RegistryConstans.REGISTRY_VALIDATOR_CODE_KEY + phoneNumber;
        String code = RandomUtil.randomNumbers(RegistryConstans.VALIDATOR_CODE_LENGTH);
        smsSendUtil.sendRegistryCode(phoneNumber, code, (result) -> {

            if (result.isOk()) {
                redisTemplate.opsForValue().set(key, code, RegistryConstans.VALIDATOR_CODE_EXPRICE, RegistryConstans.VALIDATA_CODE_EXPRICE_TIMEUNIT);
                LOGGER.info("alibaba.sms send success code:" + code);
            } else {
                LOGGER.error(result.getCode() + " [] " + result.getMessage());
            }

        });
    }



}
