package cn.fan.cache;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Description
 * @Date 2020/4/30
 * @Create By admin
 */
public class HashKeyGenerator implements KeyGenerator {

    ThreadLocal<StringBuilder> stringBuilderThreadLocal=new ThreadLocal<>();

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        StringBuilder key=stringBuilderThreadLocal.get();
        if(key==null){
            key=new StringBuilder();
            stringBuilderThreadLocal.set(key);
        }else{
            key.delete(0,key.length());
        }
        key.append(o.getClass().getName().hashCode());
        key.append(method.getName().hashCode());
        Parameter[]parameters= method.getParameters();
        for(int i=0, l=parameters==null?0:parameters.length;i<l;i++){
            Parameter parameter=parameters[i];
            Object paramValue=objects[i];
            key.append(parameter.getName().hashCode());
            key.append(paramValue==null?0:paramValue.hashCode());
        }
        return key.toString();
    }
}
