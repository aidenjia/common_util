package com.jiaz.util.mobile;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

public class TargetUserVo implements Serializable {
    @Excel(name = "手机号")
    private String mobile;
    @Excel(name = "真实姓名", orderNum = "1")
    private String realName;
    @Excel(name = "注册时间", orderNum = "2", format = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;
    @Excel(name = "最后一次登录时间", orderNum = "3")
    private Date lastLoginTime;
    @Excel(name = "所属省份", orderNum = "4")
    private String province;
    @Excel(name = "所属城市", orderNum = "5")
    private String city;
    @Excel(name = "运营商", orderNum = "6")
    private String merchant;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
