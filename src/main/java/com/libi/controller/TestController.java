package com.libi.controller;

import com.libi.commons.ResponseTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseTemplate getTest(HttpServletRequest request) {
        return testMethod(request);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseTemplate postTest(HttpServletRequest request) {
        return testMethod(request);
    }

    private ResponseTemplate testMethod(HttpServletRequest request) {
        String param = request.getParameter("param");
        String param2 = request.getParameter("param2");
        TestBean testBean = new TestBean();
        testBean.setCurrentTime(System.currentTimeMillis());
        testBean.setParam(param);
        testBean.setParam2(param2);
        ResponseTemplate<TestBean> responseTemplate = new ResponseTemplate<TestBean>();
        responseTemplate.setMessage("成功");
        responseTemplate.setData(testBean);
        return responseTemplate;
    }
}

class TestBean{
    private String param;
    private String param2;
    private Long currentTime;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }
}
