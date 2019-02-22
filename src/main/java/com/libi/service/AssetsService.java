package com.libi.service;

import com.libi.entity.Assets;

import java.util.List;

/**
 * @author libi
 */
public interface AssetsService {
    /**
     * 为当前登陆用户创建新的资产
     * @param assets
     * @return
     */
    boolean createNewAssets(Assets assets);

    /**
     * 获取用户下的所有资产
     * @param owner
     * @return
     */
    List<Assets> getUserAllAssets(Long owner);

    /**
     * 更新资产名字和备注
     * @param name
     * @return
     */
    boolean updateAssets(String name,String note ,Long id);

    /**
     * 更改资产的单/双向性
     * @return
     */
    boolean changeAssetsOneWay(Long id);

    /**
     * 根据ID选择对应的资产
     * @param id
     * @return
     */
    Assets selectById(Long id);

}
