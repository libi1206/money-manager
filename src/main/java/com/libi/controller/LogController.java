package com.libi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author libi
 */
@Controller
public class LogController {
    @RequestMapping()
    public String forLog(HttpServletRequest request) {
        return "forward:/error/404";
    }
}
