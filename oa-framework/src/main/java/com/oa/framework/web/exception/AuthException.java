package com.oa.framework.web.exception;

import com.oa.framework.web.enums.AuthExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author rogers
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class AuthException extends RuntimeException{

    private Integer code;
    private String message;

    public AuthException() {
        super("认证失败！");
        this.code = 500;
        this.message = "认证失败！";
    }

    public AuthException(AuthExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }


}
