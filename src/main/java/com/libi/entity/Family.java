package com.libi.entity;

import com.libi.base.BaseEntity;

/**
 * @author libi
 * 家庭组
 */
public class Family extends BaseEntity {
    private String familyName;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
