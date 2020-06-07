package cn.fan.sms.util.alibabasms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Description
 * @Date 2020/4/29
 * @Create By admin
 */

public class Result {

    /**
     * {
     *         "Message": "OK",
     *             "RequestId": "EF36712D-385A-484C-85D7-7DC9D8495003",
     *             "BizId": "226719688156840023^0",
     *             "Code": "OK"
     * }
     *{
     * 	"Message": "未开通云通信产品的阿里云客户",
     * 	"RequestId": "fece4d11-00e4-4d00-b4e5-becf859a6213",
     * 	"Code": "isv.PRODUCT_UN_SUBSCRIPT"
     * }
     *
     *
     */
    private String code;
    private String message;
    private String requestId;

    public boolean isOk(){
        return "OK".equals(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


}
