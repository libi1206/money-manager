package com.libi.controller;

import com.libi.commons.ResponseTemplate;
import com.libi.entity.SysUser;
import com.libi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.libi.constant.SecurityConst.*;
import static com.libi.constant.ErrorCodeConst.*;
/**
 * @author libi
 * 控制用户注册的url
 */
@Controller
@RequestMapping(REGISTER_URL)
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseTemplate<String> register(SysUser newUser) {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        newUser.setCreateTime(System.currentTimeMillis());
        if (newUser.getAuthority() == null) {
            newUser.setAuthority(ROLE_USER);
        }
        if (userService.userRegister(newUser)) {
            response.setData("注册成功");
        } else {
            response.setCode(PARAMETER_ERROR);
            response.setData("注册失败，可能是用户名或手机号重复");
        }
        return response;
    }


}
