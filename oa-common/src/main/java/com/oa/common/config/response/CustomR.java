package com.oa.common.config.response;

import com.oa.common.constant.HttpStatus;
import com.oa.common.utils.StringUtils;

import java.util.HashMap;

/**
 * @author rogers
 */
public class CustomR extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public CustomR()
    {
    }


    public CustomR(int code, String msg)
    {
        put("code", code);
        put("msg", msg);
    }


    public CustomR(int code, String msg, Object data)
    {
        super.put("code", code);
        super.put("msg", msg);
        if (StringUtils.isNotNull(data))
        {
            super.put("data", data);
        }
    }


    public static CustomR success()
    {
        return CustomR.success("请求成功");
    }


    public static CustomR success(Object data)
    {
        return CustomR.success("请求成功", data);
    }


    public static CustomR success(String msg)
    {
        return CustomR.success(msg, null);
    }


    public static CustomR success(String msg, Object data)
    {
        return new CustomR(HttpStatus.SUCCESS, msg, data);
    }


    public static CustomR error()
    {
        return CustomR.error("请求失败");
    }


    public static CustomR error(String msg)
    {
        return CustomR.error(msg, null);
    }


    public static CustomR error(String msg, Object data)
    {
        return new CustomR(HttpStatus.ERROR, msg, data);
    }


    public static CustomR error(int code, String msg)
    {
        return new CustomR(code, msg, null);
    }
}
