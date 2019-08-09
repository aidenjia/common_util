package com.jiaz.util.mobile;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

public class UserVo implements Serializable {
    @Excel(name = "手机号", orderNum = "0")
    private String mobile;
    @Excel(name = "真实姓名", orderNum = "1")
    private String realName;
    @Excel(name = "注册时间", orderNum = "2", format = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;
    @Excel(name = "最后一次登录时间", orderNum = "3")
    private Date lastLoginTime;

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
}
