package com.libi.constant;

/**
 * @author libi
 * 安全框架涉及的常量
 */
public class SecurityConst {

    /**
     * 登录登出的URL
     */
    public static final String LOGIN_URL = "/login";
    public static final String LOGIN_SUCCESS_URL = "/login/success";
    public static final String LOGIN_FAIL_URL = "/login/fail";
    public static final String LOGOUT_URL = "/logout";
    public static final String LOGOUT_SUCCESS_URL = "/logout/success";
    public static final String LOGOUT_FAIL_URL = "/logout/fail";

    /**
     * 用户名和密码的参数名
     */
    public static final String USER_NAME_PARAMETER = "username";
    public static final String PASSWORD_PARAMETER = "password";

    /**
     * 角色控制的字符串
     */
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

}
