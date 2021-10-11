package com.oa.common.config.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author rogers
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R  implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Integer SUCCESS_CODE = 200;

    public static final Integer ERROR_CODE = 500;

    public static final String SUCCESS_MSG = "请求成功";

    public static final String ERROR_MSG = "请求失败";

    private Integer code;

    private String msg;

    private Object data;

    public static R success() {
        return new R(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static R success(Object data) {
        return new R(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static R success(String msg, Object data) {
        return new R(SUCCESS_CODE, msg, data);
    }

    public static R error() {
        return new R(ERROR_CODE, ERROR_MSG, null);
    }

    public static R error(String msg) {
        return new R(ERROR_CODE, msg, null);
    }

    public static R error(int code ,String msg) {
        return new R(code, msg, null);
    }
}
