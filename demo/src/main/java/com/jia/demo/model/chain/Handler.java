package com.jia.demo.model.chain;

public class Handler {
    public static void main(String[] args) {
        // 得到请求的数据
        String data = "data";
        FilterChain filterChain = new FilterChain();
        // 处理数据
        filterChain.processData(data);
    }
}
