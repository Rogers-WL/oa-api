package com.oa.framework.web.enums;

import lombok.Getter;

/**
 * @author rogers
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
@Getter
public enum BusinessExceptionEnum {

    DATA_CHANGED(1000, "数据异常，请刷新后重试");

    private Integer code;
    private String message;

    BusinessExceptionEnum(int code, String message) {
        this.code = code;
        this.message  = message;
    }
}
