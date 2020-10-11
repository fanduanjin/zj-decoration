package cn.fan.model.user;

import cn.fan.core.regexp.RegexpConstans;
import cn.fan.model.BaseModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author admin
 * @Description
 * @Date 2020/4/21
 * @Create By admin
 */

@Data
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


}
