package com.libi.entity;

import com.libi.base.BaseEntity;

/**
 * @author libi
 * 用户
 */
public class SysUser extends BaseEntity {
    private String userName;
    private String password;
    private Boolean sex;
    private String authority;
    private String neckName;
    private String headImg;
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getNeckName() {
        return neckName;
    }

    public void setNeckName(String neckName) {
        this.neckName = neckName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
