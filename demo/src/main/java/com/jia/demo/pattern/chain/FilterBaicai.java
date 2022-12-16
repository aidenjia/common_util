package com.jia.demo.pattern.chain;

public class FilterBaicai implements Filter{
    @Override
    public void doFilter(String data) {
        System.out.println("filter Baicai");
    }
}
