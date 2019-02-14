package com.libi.test;

import com.libi.config.RootConfig;
import com.libi.config.WebConfig;
import com.libi.dao.AssetsMapper;
import com.libi.dao.FamilyMapper;
import com.libi.dao.UserMapper;
import com.libi.entity.Assets;
import com.libi.entity.Family;
import com.libi.entity.User;
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
    private UserMapper userMapper;
    @Autowired
    private AssetsMapper assetsMapper;

    @Test
    public void testDao() {
        User user = userMapper.select(1L);
        System.out.println(user.getUserName());

        Assets assets = new Assets();
        assets.setAssetsName("支付宝");
        assets.setMoney(100.0);
        assets.setOnwer(1L);
        assets.setOneWay(false);
        assets.setCreatTime(System.currentTimeMillis());
        assetsMapper.insert(assets);

        System.out.println("插入完成,id="+assets.getId());

    }
}
