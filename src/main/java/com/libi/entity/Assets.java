package com.libi.entity;

import com.libi.base.BaseEntity;

/**
 * @author libi
 * 资产实体类
 */
public class Assets extends BaseEntity {
    private Long owner;
    private String assetsName;
    private Double money;
    private String note;
    private Boolean oneWay;

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Boolean getOneWay() {
        return oneWay;
    }

    public void setOneWay(Boolean oneWay) {
        this.oneWay = oneWay;
    }

    public Long getOnwer() {
        return owner;
    }

    public void setOnwer(Long onwer) {
        this.owner = onwer;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
