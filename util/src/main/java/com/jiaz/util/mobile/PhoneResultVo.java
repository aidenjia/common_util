package com.jiaz.util.mobile;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class PhoneResultVo implements Serializable {
    @JSONField(name = "status")
    private String status;
    @JSONField(name = "phone")
    private String phone;
    @JSONField(name = "area")
    private String area;
    @JSONField(name = "postno")
    private String postno;
    @JSONField(name = "att")
    private String att;
    @JSONField(name = "ctype")
    private String ctype;
    @JSONField(name = "par")
    private String par;
    @JSONField(name = "prefix")
    private String prefix;
    @JSONField(name = "operators")
    private String operators;
    @JSONField(name = "style_simcall")
    private String styleSimcall;
    @JSONField(name = "style_citynm")
    private String styleCitym;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPostno() {
        return postno;
    }

    public void setPostno(String postno) {
        this.postno = postno;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getStyleSimcall() {
        return styleSimcall;
    }

    public void setStyleSimcall(String styleSimcall) {
        this.styleSimcall = styleSimcall;
    }

    public String getStyleCitym() {
        return styleCitym;
    }

    public void setStyleCitym(String styleCitym) {
        this.styleCitym = styleCitym;
    }
}
