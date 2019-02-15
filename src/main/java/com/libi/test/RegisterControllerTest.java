package com.libi.test;

import com.libi.commons.ResponseTemplate;
import com.libi.config.RootConfig;
import com.libi.config.WebConfig;
import com.libi.controller.RegisterController;
import com.libi.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author libi
 * 测试用户注册
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class,WebConfig.class})
public class RegisterControllerTest {
    @Autowired
    RegisterController registerController;

    @Test
    public void testRegister() {
        SysUser user = new SysUser();
        user.setUserName("libi1206");
        user.setPassword("123");

        ResponseTemplate responseTemplate = registerController.register(user);
        System.out.println(responseTemplate.getData());
    }
}
