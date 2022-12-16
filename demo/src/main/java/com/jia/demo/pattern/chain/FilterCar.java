package com.jia.demo.pattern.chain;

public class FilterCar implements Filter{
    @Override
    public void doFilter(String data) {
        System.out.println("filter cars");
    }
}
