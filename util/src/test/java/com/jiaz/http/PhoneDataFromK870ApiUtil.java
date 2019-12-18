package com.jiaz.http;


import com.jiaz.util.http.HttpClientResult;
import com.jiaz.util.http.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;


public class PhoneDataFromK870ApiUtil {

    public static final String apiUrl = "http://api.k780.com:88";

    public static HttpClientResult getPhneData(String num) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("app", "phone.get");
        param.put("appkey", "10003");
        param.put("sign", "b59bc3ef6191eb9f747dd4e83c99f2a4");
        param.put("phone", num);
        HttpClientResult result = HttpClientUtils.doGet(apiUrl, param);
        return result;
    }
}
