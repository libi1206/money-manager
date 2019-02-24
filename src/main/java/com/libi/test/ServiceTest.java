package com.libi.test;

import com.libi.config.RootConfig;
import com.libi.config.WebConfig;
import com.libi.entity.Family;
import com.libi.entity.SysUser;
import com.libi.service.AssetsService;
import com.libi.service.FamilyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author libi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class,WebConfig.class})
public class ServiceTest {
    @Autowired
    private AssetsService assetsService;
    @Autowired
    private FamilyService familyService;


    @Test
    public void testAssetService() {
        assetsService.changeAssetsOneWay(3L);
        assetsService.updateAssets("微信", "微信零钱",3L);
        System.out.println("完成");
    }

    @Test
    public void testFamilyService() {
        Family family = new Family();
        family.setFamilyName("李比之家");
        family.setCreateTime(System.currentTimeMillis());
        familyService.createFamily(family, 7L);
        System.out.println("创建成功，ID是"+family.getId());

        familyService.joinFamily(family.getId(), 8L);

        List<SysUser> userList = familyService.getAllMembers(family.getId());
        for (SysUser member : userList) {
            System.out.println("id:"+member.getId()+"userName:"+member.getUserName());
        }

    }
}
