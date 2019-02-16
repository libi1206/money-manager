package com.libi.controller;

import com.libi.commons.ResponseTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.libi.constant.SecurityConst.*;

/**
 * @author libi
 */
@Controller
@RequestMapping(LOGOUT_URL)
public class LogoutController {
    @RequestMapping(value = "/success")
    @ResponseBody
    public ResponseTemplate logoutSuccess() {
        ResponseTemplate<String> responseTemplate = new ResponseTemplate<String>();
        responseTemplate.setData("登出成功");
        return responseTemplate;
    }

    @RequestMapping(value = "/fail")
    @ResponseBody
    public ResponseTemplate logoutfail() {
        ResponseTemplate<String> responseTemplate = new ResponseTemplate<String>();
        responseTemplate.setCode(10008);
        responseTemplate.setData("登出失败");
        return responseTemplate;
    }
}
