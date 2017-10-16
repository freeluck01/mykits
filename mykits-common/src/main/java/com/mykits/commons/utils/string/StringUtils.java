package com.mykits.commons.utils.string;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by caoxingming on 2017/10/13.
 */
public class StringUtils {
    private static Logger logger = LogManager.getLogger(StringUtils.class);
    /**
     * 将Java对象转为字符串
     * @param obj Java对象
     * @param fieldName Java对象中需要toString的字段，例如："field1"，"field2","field3"
     * @return
     */
    @Deprecated
    public static String objToString(Object obj, String... fieldName) {
        if(obj==null){
            return "";
        }
        Class cls = obj.getClass();
        String str;
        StringBuffer buffer = new StringBuffer(cls.getSimpleName() + ":{");
        try {
            Method[] methods = cls.getMethods(); //只获取pulbic方法
            //如果该方法的第二个参数【String... fieldName】有值，就只toString这些字段，否则，toString全部字段
            if (null != fieldName && fieldName.length > 0) { //部分field
                for (Method method : methods) {
                    String mn = method.getName();
                    for (String fn : fieldName) {
                        if (mn.equalsIgnoreCase("get" + fn)) {
                            String value = method.invoke(obj).toString();
                            buffer.append(fn + "=" + value + ", ");
                        }
                    }
                }
            } else { //全部field
                Field[] fields = cls.getDeclaredFields();
                for (Method method : methods) {
                    String mn = method.getName();
                    for (Field field : fields) {
                        String fn = field.getName().toString();
                        if (mn.equalsIgnoreCase("get" + fn)) {
                            String value = method.invoke(obj).toString();
                            buffer.append(fn + "=" + value + ", ");
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("StringUtil工具类objToString异常。"+e);
            buffer.append("转换对象为字符串时发生异常...  ");
        }

        if(buffer.toString().endsWith("{")){ //说明没有字段或异常
            buffer.append("}");
            str = buffer.toString();
        }else{
            str = buffer.substring(0, buffer.length() - 2) + "}";
        }
        return str;
    }
}
