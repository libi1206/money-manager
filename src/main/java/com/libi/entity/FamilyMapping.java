package com.libi.entity;

import com.libi.base.BaseEntity;

/**
 * @author libi
 * 家庭和用户的对应关系
 */
public class FamilyMapping extends BaseEntity {
    private Long userId;
    private Long familyId;
    private Boolean isAdmin;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
