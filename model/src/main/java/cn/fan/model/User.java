package cn.fan.model;

import cn.fan.core.regexp.RegexpConstans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Description
 * @Date 2020/4/21
 * @Create By admin
 */


public class User extends BaseModel {


    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = RegexpConstans.USERNAME, message = "用户名格式不正确")
    private String userName;

    @Pattern(regexp = RegexpConstans.PASSWORD, message = "密码格式不正确，必须包含数字、大小写字符，如：786793.pwd")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Pattern(regexp = RegexpConstans.PHONENUMBER, message = "用户名格式不正确，必须大写字母开头，长度6-16位，如：Fanduanjin")
    private String phoneNumber;

    private String headImageUrl;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }
}
