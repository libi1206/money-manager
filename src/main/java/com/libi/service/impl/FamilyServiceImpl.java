package com.libi.service.impl;

import com.libi.dao.FamilyMapper;
import com.libi.dao.FamilyMappingMapper;
import com.libi.entity.Family;
import com.libi.entity.FamilyMapping;
import com.libi.entity.SysUser;
import com.libi.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author libi
 */
@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    private FamilyMapper familyMapper;
    @Autowired
    private FamilyMappingMapper familyMappingMapper;

    @Override
    public boolean createFamily(Family family,Long userId) {
        //TODO 这个方法需要注册为事物
        boolean result1 = familyMapper.insert(family) == 1;
        FamilyMapping familyMapping = new FamilyMapping();
        familyMapping.setFamilyId(family.getId());
        familyMapping.setUserId(userId);
        familyMapping.setIsAdmin(true);
        boolean result2 = familyMappingMapper.insert(familyMapping) == 1;
        return result1 && result2;
    }

    @Override
    public boolean joinFamily(Long familyId,Long userId) {
        FamilyMapping familyMapping = new FamilyMapping();
        familyMapping.setFamilyId(familyId);
        familyMapping.setUserId(userId);
        familyMapping.setIsAdmin(false);
        return familyMappingMapper.insert(familyMapping) == 1;
    }

    @Override
    public boolean quitFamily(Long familyId, Long userId) {
        return 1 == familyMappingMapper.delete(userId, familyId);
    }

    @Override
    public List<SysUser> getAllMembers(Long familyId) {
        return familyMappingMapper.selectAllUserInFamily(familyId);
    }

    @Override
    public List<Family> getAllFamilies(Long loginUserId) {
        return familyMappingMapper.selectAllFamilyInUser(loginUserId);
    }
}
