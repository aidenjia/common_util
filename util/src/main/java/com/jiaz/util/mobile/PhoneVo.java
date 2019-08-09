package com.jiaz.util.mobile;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class PhoneVo implements Serializable {
    @JSONField(name="success")
    private String success;
    @JSONField(name="result")
    private PhoneResultVo phoneResultVo;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public PhoneResultVo getPhoneResultVo() {
        return phoneResultVo;
    }

    public void setPhoneResultVo(PhoneResultVo phoneResultVo) {
        this.phoneResultVo = phoneResultVo;
    }
}
