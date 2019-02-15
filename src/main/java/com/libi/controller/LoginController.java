package com.libi.controller;

import com.libi.commons.ResponseTemplate;
import com.libi.dao.SysUserMapper;
import com.libi.entity.SysUser;
import com.libi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.libi.constant.SecurityConst.*;

/**
 * @author libi
 * 用于用户登陆的控制器，用户登陆调用的接口
 */
@Controller
@RequestMapping(LOGIN_URL)
public class LoginController {
    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST, value = "/success")
    @ResponseBody
    public ResponseTemplate<SysUser> loginSuccess() {
        ResponseTemplate<SysUser> response = new ResponseTemplate<SysUser>();
        response.setCode(0);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser user = userService.userLogin(userDetails.getUsername());
        user.setPassword("嘿嘿，不告诉你");
        response.setData(user);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fail")
    @ResponseBody
    public ResponseTemplate<String> loginFail() {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(10006);
        response.setData("登录的账号或密码有误");
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/me")
    public String  getUserInfo() {
        return "redirect:"+LOGIN_SUCCESS_URL;
    }


}
