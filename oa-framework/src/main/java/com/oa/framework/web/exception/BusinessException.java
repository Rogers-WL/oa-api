package com.oa.framework.web.exception;

import com.oa.framework.web.enums.BusinessExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author rogers
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException{

    private Integer code;

    private String message;

    public BusinessException() {
        this.code = 500;
        this.message = "请求失败";
    }

    public BusinessException(BusinessExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }
}
