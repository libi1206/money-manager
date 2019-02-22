package com.libi.service.impl;

import com.libi.dao.AssetsMapper;
import com.libi.entity.Assets;
import com.libi.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author libi
 */
@Service
public class AssetsServiceImpl implements AssetsService {
    @Autowired
    private AssetsMapper assetsMapper;

    @Override
    public boolean createNewAssets(Assets assets) {
        return assetsMapper.insert(assets) == 1;
    }

    @Override
    public List<Assets> getUserAllAssets(Long owner) {
        List<Assets> usersAssets = assetsMapper.selectUserAssets(owner);
        return usersAssets;
    }

    @Override
    public boolean updateAssets(String name, String note, Long id) {
        Assets assets = assetsMapper.select(id);
        if (name != null) {
            assets.setAssetsName(name);
        }
        if (note != null) {
            assets.setNote(note);
        }
        return assetsMapper.update(assets) == 1;
    }

    @Override
    public boolean changeAssetsOneWay(Long id) {
        Assets assets = assetsMapper.select(id);
        assets.setOneWay(!assets.getOneWay());
        return assetsMapper.update(assets) == 1;
    }

    @Override
    public Assets selectById(Long id) {
        return assetsMapper.select(id);
    }
}
