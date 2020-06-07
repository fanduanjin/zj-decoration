package cn.fan.core.regexp;

import cn.fan.core.constans.RegistryConstans;

/**
 * @Description
 * @Date 2020/4/29
 * @Create By admin
 */
public class RegexpConstans {
    public static final String PHONENUMBER ="^1(3|4|5|7|8)\\d{9}$";
    //字母  数字 最少一次
    public static final String PASSWORD="^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{6,16}$";
    public static final String USERNAME="^(?=[A-Z]+)(?=[a-zA-Z]*).{6,16}$";
    private  RegexpConstans(){}
}
