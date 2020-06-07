package cn.fan.vo;

import cn.fan.model.User;

import javax.validation.constraints.NotBlank;

/**
 * @Description
 * @Date 2020/5/2
 * @Create By admin
 */
public class UserRegistryVo extends User {
    @NotBlank(message = "请输入验证码")
    private String validatorCode;

    public String getValidatorCode() {
        return validatorCode;
    }

    public void setValidatorCode(String validatorCode) {
        this.validatorCode = validatorCode;
    }
}
