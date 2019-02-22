package com.libi.test;

import com.libi.config.RootConfig;
import com.libi.config.WebConfig;
import com.libi.service.AssetsService;
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
public class ServiceTest {
    @Autowired
    AssetsService assetsService;

    @Test
    public void testAssetService() {
        assetsService.changeAssetsOneWay(3L);
        assetsService.updateAssets("微信", "微信零钱",3L);
        System.out.println("完成");
    }
}
