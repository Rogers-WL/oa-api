package com.oa.framework.web.enums;



import lombok.Getter;

/**
 * @author rogers
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
@Getter
public enum AuthExceptionEnum {

    NOT_LOGIN_ERROR(1401, "用户未登录"),

    USER_NOT_EXISTED(1405, "账号不存在或被禁用"),

    PASSWORD_ERROR(1410, "账号密码错误"),

    PASSWORD_DECRYPT(1415, "密码解密失败，该账号已失效"),

    LOGIN_EXPIRED(1420, "登录已过期，请重新登录"),

    ACCOUNT_FREEZE_ERROR(1430, "账号被冻结"),

    NO_ROLE_ERROR(1440, "用户没有分配角色，获取菜单失败"),

    VALID_CODE_ERROR(1450, "验证码错误"),

    NO_PERMISSION(1500, "没有权限访问资源");

    AuthExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;
}
