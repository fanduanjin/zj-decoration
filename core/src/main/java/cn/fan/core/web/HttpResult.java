package  cn.fan.core.web;

import java.io.Serializable;

/**
 * @Description
 * @Date 2020/4/21
 * @Create By admin
 */
public class HttpResult {


    private  int code;
    private String msg;
    private Object data;

    public static HttpResult SUCCESS_RESULT(Object data){
        return new HttpResult(200,data);
    }


    /**
     * 认证成功
     * @return
     */
    public static HttpResult SUCCESS_AUTHNTICATION(){
        return new HttpResult(200,"认证成功");
    }

    /**
     * 认证失败
     * @param msg
     * @return
     */
    public static HttpResult FAILD_AUTHNATICATION(String msg){
        return new HttpResult(602,"认证失败!  "+msg);
    }

    /**
     * 授权失败
     * @param msg
     * @return
     */
    public static HttpResult FAILD_AUTHORIZATION (String msg){
        return new HttpResult(603,"授权失败!  "+msg);
    }

    /**
     * 参数验证失败
     * @param msg
     * @return
     */
    public static HttpResult FAILD_VALIDATOR(String msg){
        return new HttpResult(7867,msg);
    }
    public static HttpResult SUCCESS_RESULT(){
        return new HttpResult(200,null);
    }


    public static HttpResult FAILD_RESULT(String msg){
        return new HttpResult(201,msg);
    }

    public HttpResult(){}

    public HttpResult (int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public HttpResult(int code,Object data){
        this.code=code;
        this.data=data;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
