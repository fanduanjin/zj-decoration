package cn.fan.core.constans;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Date 2020/4/26
 * @Create By admin
 */
public class RegistryConstans {

    public static final String REGISTRY_VALIDATOR_CODE_KEY = "reg_valicode:";
    public static final int VALIDATOR_CODE_LENGTH = 6;
    public static final int VALIDATOR_CODE_EXPRICE = 30;
    public static final TimeUnit VALIDATA_CODE_EXPRICE_TIMEUNIT =TimeUnit.MINUTES;

    private RegistryConstans() {
    }
}
