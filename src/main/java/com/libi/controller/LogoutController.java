package com.libi.controller;

import com.libi.commons.ResponseTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.libi.constant.SecurityConst.*;
import static com.libi.constant.ErrorCodeConst.*;

/**
 * @author libi
 */
@Controller
@RequestMapping(LOGOUT_URL)
public class LogoutController {
    @RequestMapping(value = "/success")
    @ResponseBody
    public ResponseTemplate logoutSuccess(HttpServletRequest request) {
        ResponseTemplate<String> responseTemplate = new ResponseTemplate<String>();
        responseTemplate.setMessage("登出成功");
        return responseTemplate;
    }

    @RequestMapping(value = "/fail")
    @ResponseBody
    public ResponseTemplate logoutFail(HttpServletRequest request) {
        ResponseTemplate<String> responseTemplate = new ResponseTemplate<String>();
        responseTemplate.setCode(UNKNOWN_ERROR);
        responseTemplate.setMessage("登出失败");
        return responseTemplate;
    }
}
