package com.libi.controller;

import com.libi.commons.ResponseTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.libi.constant.ErrorCodeConst.*;
import static com.libi.constant.SecurityConst.*;

/**
 * @author libi
 * 处理出错时的相应
 */
@Controller
@RequestMapping(value = EXCEPTION_URL)
public class ExceptionController{

    /**
     * 请求参数有误或者无法被服务器理解
     * @return
     */
    @RequestMapping("/400")
    @ResponseBody
    public ResponseTemplate<String> handle400(HttpServletRequest request) {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(PARAMETER_ERROR);
        response.setMessage("请求参数有误或者无法被服务器理解");
        return response;
    }

    /**
     * 请求被拒绝，大概率没有权限
     * @return
     */
    @RequestMapping("/403")
    @ResponseBody
    public ResponseTemplate<String> handle403(HttpServletRequest request) {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(FORBIDDEN_ERROR);
        response.setMessage("请求被拒绝,可能是权限不够");
        return response;
    }

    @RequestMapping("/404")
    @ResponseBody
    public ResponseTemplate<String> handle404(HttpServletRequest request) {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(NOT_FIND_ERROR);
        response.setMessage("找不到对应的响应，可能是请求的url有误");
        return response;
    }

    @RequestMapping("/405")
    @ResponseBody
    public ResponseTemplate<String> handle405(HttpServletRequest request) {
        ResponseTemplate<String> responseTemplate = new ResponseTemplate<String>();
        responseTemplate.setCode(PARAMETER_ERROR);
        responseTemplate.setMessage("该请求方法不允许");
        return responseTemplate;
    }
    @RequestMapping("/500")
    @ResponseBody
    public ResponseTemplate<String> handle500(HttpServletRequest request) {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(SERVICE_ERROR);
        response.setMessage("服务器内部出错");
        return response;
    }

    @RequestMapping("/default")
    @ResponseBody
    public ResponseTemplate<String> handleDefault(HttpServletRequest request) {
        ResponseTemplate<String> response = new ResponseTemplate<String>();
        response.setCode(UNKNOWN_ERROR);
        response.setMessage("出现了意料之外的错误");
        return response;
    }
}
