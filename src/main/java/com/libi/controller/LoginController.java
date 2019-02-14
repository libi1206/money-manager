package com.libi.controller;

import com.libi.commons.ResponseTemplate;
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
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.POST,value = "/success")
    @ResponseBody
    public ResponseTemplate<UserDetails> loginSuccess() {
        ResponseTemplate<UserDetails> response = new ResponseTemplate<UserDetails>();
        response.setCode(0);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        response.setData(userDetails);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/me")
    @ResponseBody
    public ResponseTemplate<UserDetails> test() {
        ResponseTemplate<UserDetails> response = new ResponseTemplate<UserDetails>();
        response.setCode(0);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        response.setData(userDetails);
        return response;
    }



}
