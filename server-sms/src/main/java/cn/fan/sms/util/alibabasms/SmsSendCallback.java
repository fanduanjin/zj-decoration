package cn.fan.sms.util.alibabasms;

/**
 * @Description
 * @Date 2020/4/29
 * @Create By admin
 */
@FunctionalInterface
public interface SmsSendCallback {
    void callback(Result result);
}
