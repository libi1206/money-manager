package com.libi.controller;

import com.libi.base.BaseController;
import com.libi.commons.ResponseTemplate;
import com.libi.entity.SysUser;
import com.libi.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.libi.constant.SecurityConst.*;

/**
 * @author libi
 */
@Controller
@RequestMapping(USER_URL)
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(this.getClass());


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseTemplate updateUser(HttpServletRequest request) {
        Boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
        logger.warn(sex);
        String neckName = request.getParameter("neckName");
        logger.warn(neckName);
        String phone = request.getParameter("phone");
        logger.warn(phone);
        userService.updateUserInfo(getLoginUser(), sex, neckName, phone);
        ResponseTemplate<SysUser> responseTemplate = new ResponseTemplate<SysUser>();
        responseTemplate.setMessage("更新成功");
        responseTemplate.setData(userService.selectById(getLoginUser().getId()));
        return responseTemplate;
    }
}
