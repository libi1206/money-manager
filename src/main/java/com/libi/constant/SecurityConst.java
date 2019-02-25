package com.libi.constant;

/**
 * @author libi
 * 安全框架涉及的常量
 */
public class SecurityConst {

    /**
     * URL常量
     */
    public static final String LOGIN_URL = "/user/login";
    public static final String LOGIN_SUCCESS_URL = "/user/login/success";
    public static final String LOGIN_FAIL_URL = "/user/login/fail";
    public static final String LOGOUT_URL = "/user/logout";
    public static final String LOGOUT_SUCCESS_URL = "/user/logout/success";
    public static final String REGISTER_URL = "/user/register";
    public static final String ASSETS_URL = "/assets";
    public static final String FAMILY_URL = "/family";
    public static final String EXCEPTION_URL = "/error";

    /**
     * 用户名和密码的参数名
     */
    public static final String USER_NAME_PARAMETER = "username";
    public static final String PASSWORD_PARAMETER = "password";

    /**
     * 角色控制的字符串
     */
    public static final String ROLE_ADMIN = "AUTH_ADMIN";
    public static final String ROLE_USER = "AUTH_USER";

    /**
     * 数据库中的角色控制字符串
     */
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

}
