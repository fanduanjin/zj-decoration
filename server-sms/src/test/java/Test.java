import cn.fan.sms.util.alibabasms.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description
 * @Date 2020/4/29
 * @Create By admin
 */
public class Test {
    public static void main(String[] args) {
        String res="{\"Message\": \"未开通云通信产品的阿里云客户\"," +
                "\"RequestId\": \"fece4d11-00e4-4d00-b4e5-becf859a6213\""+
                ", \"Code\": \"isv.PRODUCT_UN_SUBSCRIPT\" ,\"test\":\"fsdfsd\"}";
        Result result =null;
        ObjectMapper objectMapper=new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        try {
            result= objectMapper.readValue(res,Result.class);
            System.out.println(objectMapper.writeValueAsString(result));

            result=new Result();
            result.setCode("code");
            result.setMessage("fdsfsdsd");
            System.out.println(objectMapper.writeValueAsString(result));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
