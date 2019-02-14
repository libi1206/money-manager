package com.libi.test;

import com.libi.config.RootConfig;
import com.libi.config.WebConfig;
import com.libi.dao.AssetsMapper;
import com.libi.dao.FamilyMapper;
import com.libi.dao.SysUserMapper;
import com.libi.entity.Assets;
import com.libi.entity.Family;
import com.libi.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author libi
 * 用于调试dao层
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class,WebConfig.class})
public class UserDaoTest {
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private AssetsMapper assetsMapper;

    /**
     * 唯一检测冲突报错 java.sql.SQLIntegrityConstraintViolationException
     * SQL语句写错了报错 java.sql.SQLSyntaxErrorException
     */
    @Test
    public void testDao() {
        SysUser user = new SysUser();
        user.setUserName("libi99812206");
        user.setPassword("123456");
        user.setSex(true);
        user.setAuthority("USER");
        user.setNeckName("libi2");
        user.setHeadImg("....");
        user.setPhone("13333333333");
        user.setCreatTime(System.currentTimeMillis());
        userMapper.insert(user);
        System.out.println("插入成功，id:"+user.getId());
    }
}
