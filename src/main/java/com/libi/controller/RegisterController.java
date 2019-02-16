package com.libi.controller;

import com.libi.commons.ResponseTemplate;
import com.libi.entity.SysUser;
import com.libi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

import static com.libi.constant.SecurityConst.*;
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
    public ResponseTemplate register(SysUser newUser) {
        ResponseTemplate response = new ResponseTemplate();
        newUser.setCreatTime(System.currentTimeMillis());
        if (newUser.getAuthority() == null) {
            newUser.setAuthority(ROLE_USER);
        }
        if (userService.userRegister(newUser)) {
            response.setData("注册成功");
        } else {
            response.setCode(10007);
            response.setData("注册失败，可能是用户名或手机号重复");
        }
        return response;
    }


}
