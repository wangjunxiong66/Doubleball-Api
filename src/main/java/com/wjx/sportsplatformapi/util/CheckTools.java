package com.wjx.sportsplatformapi.util;


import java.util.List;

public class CheckTools {

    /**
     * 判断对象为空
     * @param obj 对象名
     * @return 是否不为空
     */
//    SuppressWarnings压制警告，即去除警告。rawtypes是说传参时也要传递带泛型的参数
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj)
    {
        if (obj == null)
        {
            return true;
        }
        if ((obj instanceof List))
        {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String))
        {
            return ((String) obj).trim().equals("");
        }
        return false;
    }

    /**
     * 判断对象不为空
     * @param obj 对象名
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }



}
