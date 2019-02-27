package com.libi.base;

import com.libi.entity.SysUser;
import com.libi.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author libi
 */
public class BaseController {
    @Autowired
    private UserService userService;

    protected SysUser getLoginUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser user = userService.userLogin(userDetails.getUsername());
        return user;
    }
}
