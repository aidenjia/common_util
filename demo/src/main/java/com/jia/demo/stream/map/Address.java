package com.jia.demo.stream.map;

import java.util.List;

public class Address {
    private String province;
    private List<String> cityList;//市集合
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getCityList() {
        return cityList;
    }

    public void setCityList(List<String> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", cityList=" + cityList +
                '}';
    }
}
