package com.libi.controller;

import com.libi.commons.ResponseTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author libi
 * 处理出错时的相应
 */
@Controller
@RequestMapping(value = "/error")
public class ExceptionController{

    /**
     * 请求参数有误或者无法被服务器理解
     * @return
     */
    @RequestMapping("/400")
    @ResponseBody
    public ResponseTemplate<String> handle400() {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(10001);
        response.setData("请求参数有误或者无法被服务器理解");
        return response;
    }

    /**
     * 请求被拒绝，大概率没有权限
     * @return
     */
    @RequestMapping("/403")
    @ResponseBody
    public ResponseTemplate<String> handle403() {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(10002);
        response.setData("请求被拒绝");
        return response;
    }

    @RequestMapping("/404")
    @ResponseBody
    public ResponseTemplate<String> handle404() {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(10003);
        response.setData("找不到对应的响应，可能是请求的url有误");
        return response;
    }

    @RequestMapping("/405")
    @ResponseBody
    public ResponseTemplate<String> handle405() {
        ResponseTemplate<String> responseTemplate = new ResponseTemplate<String>();
        responseTemplate.setCode(10001);
        responseTemplate.setData("该请求方法不允许");
        return responseTemplate;
    }
    @RequestMapping("/500")
    @ResponseBody
    public ResponseTemplate<String> handle500() {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(10004);
        response.setData("服务器内部出错");
        return response;
    }

    @RequestMapping("/default")
    @ResponseBody
    public ResponseTemplate<String> handleDefault() {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(10005);
        response.setData("出现了意料之外的错误");
        return response;
    }
}
