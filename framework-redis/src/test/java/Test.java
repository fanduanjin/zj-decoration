import cn.fan.serializer.KryoRedisSerializer;
import com.esotericsoftware.kryo.Kryo;

/**
 * @Description
 * @Date 2020/4/28
 * @Create By admin
 */
public class Test {

    public static void main(String[] args) {
        KryoRedisSerializer kryoRedisSerializer = new KryoRedisSerializer(Object.class);
        String str = "sfsdfdsfsfs";
        byte[] bytes = kryoRedisSerializer.serialize(str);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(kryoRedisSerializer.deserialize(bytes));
            }
        };
        Thread thread=new Thread(runnable);
        thread.run();
        System.out.println(kryoRedisSerializer.deserialize(bytes));
    }

}
