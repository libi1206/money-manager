package com.libi.test;

import com.libi.config.RootConfig;
import com.libi.config.WebConfig;
import com.libi.dao.UserMapper;
import com.libi.entity.User;
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
public class UserDaoTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testDao() {
        User user = userMapper.select(1L);
        System.out.println(user.getUserName());
    }
}
