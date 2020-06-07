package cn.fan.sms.util.alibabasms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description
 * @Date 2020/4/29
 * @Create By admin
 */
@Component
@ConfigurationProperties(prefix = "alibaba.sms")
public class SmsSendUtil {
    protected DefaultProfile profile;
    protected IAcsClient client;
    protected ObjectMapper objectMapper;


    private String regionId;
    private String accessKeyId;
    private String accessSecret;
    private String version;
    private String domain;
    private String signName;
    private String action = "SendSms";
    private boolean debugmodel;
    //发送注册验证码的 templatecode
    private String registry_validata_templatecode;

    @PostConstruct
    void init() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        profile = DefaultProfile.getProfile(regionId,
                accessKeyId, accessSecret);
        client = new DefaultAcsClient(profile);
    }

    private CommonRequest buildRequest() {
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion(version);
        return request;
    }

    public void sendRegistryCode(String phoneNumber, String code, SmsSendCallback smsSendCallback) {
        if(isDebugmodel()){
            Result result=new Result();
            result.setCode("OK");
            result.setMessage("debugmodel");
            if(null!=smsSendCallback){
                smsSendCallback.callback(result);
            }
            return ;
        }
        CommonRequest request = buildRequest();
        request.setAction(action);
        request.putQueryParameter("RegionId", regionId);
        //request.putQueryParameter("PhoneNumbers", "13020254093");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        //request.putQueryParameter("SignName", "兆军装潢");
        request.putQueryParameter("SignName", signName);
        //request.putQueryParameter("TemplateCode", "SMS_189235313");
        request.putQueryParameter("TemplateCode", registry_validata_templatecode);
        //request.putQueryParameter("TemplateParam", "{code:\"432432\"}");
        StringBuilder stringBuilder = new StringBuilder("{code:\"");
        stringBuilder.append(code);
        stringBuilder.append("\"}");
        request.putQueryParameter("TemplateParam", stringBuilder.toString());
        Result result = null;
        try {
            CommonResponse response = client.getCommonResponse(request);
            String res = response.getData();
            result = objectMapper.readValue(res, Result.class);
        } catch (Exception e) {
            result = new Result();
            result.setCode(e.getClass().getName() + " : " + e.getMessage());
            result.setMessage(e.getLocalizedMessage());
        } finally {
            if (null != smsSendCallback) {
                smsSendCallback.callback(result);
            }
        }
    }


    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRegistry_validata_templatecode() {
        return registry_validata_templatecode;
    }

    public void setRegistry_validata_templatecode(String registry_validata_templatecode) {
        this.registry_validata_templatecode = registry_validata_templatecode;
    }

    public boolean isDebugmodel() {
        return debugmodel;
    }

    public void setDebugmodel(boolean debugmodel) {
        this.debugmodel = debugmodel;
    }
}
