package com.libi.test;

import com.libi.config.RootConfig;
import com.libi.config.WebConfig;
import com.libi.entity.SysUser;
import com.libi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author libi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class,WebConfig.class})
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testRegisterUser() {
        SysUser user = new SysUser();
        user.setUserName("libi");
        user.setPassword("libi1206");
        user.setAuthority("ADMIN");
        user.setCreatTime(System.currentTimeMillis());
        userService.userRegister(user);
        System.out.println("注册成功，id:"+user.getId());
    }
}
