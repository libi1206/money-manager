package com.libi.controller;

import com.libi.commons.ResponseTemplate;
import com.libi.dao.SysUserMapper;
import com.libi.entity.SysUser;
import com.libi.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.libi.constant.SecurityConst.*;
import static com.libi.constant.ErrorCodeConst.*;

/**
 * @author libi
 * 用于用户登陆的控制器，用户登陆调用的接口
 */
@Controller
@RequestMapping(LOGIN_URL)
public class LoginController {
    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger(getClass());


    @RequestMapping(value = "/success")
    @ResponseBody
    public ResponseTemplate<SysUser> loginSuccess(HttpServletRequest request) {
        ResponseTemplate<SysUser> response = new ResponseTemplate<SysUser>();
        response.setCode(0);
        response.setMessage("成功");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser user = userService.userLogin(userDetails.getUsername());
        user.setPassword("嘿嘿，不告诉你");
        response.setData(user);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fail")
    @ResponseBody
    public ResponseTemplate<String> loginFail(HttpServletRequest request) {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(LOGIN_FAIL_ERROR);
        response.setMessage("登录的账号或密码有误");
        return response;
    }

    @RequestMapping(value = "/me")
    public String getUserInfo(HttpServletRequest request) {
        return "forward:" + LOGIN_SUCCESS_URL;
    }

    /**
     * TODO 请求转发给LoginURL无法正常判断
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public String loginForPhone(HttpServletRequest request) {
        String phoneNumber = request.getParameter("phone");
        System.out.println(phoneNumber);
        SysUser user = userService.selectByPhoneNumber(phoneNumber);
        request.setAttribute("username", user.getUserName());
        return "forward:" + LOGIN_URL;
    }


}
