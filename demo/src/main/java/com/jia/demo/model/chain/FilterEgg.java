package com.jia.demo.model.chain;

public class FilterEgg implements Filter{
    @Override
    public void doFilter(String data) {
        System.out.println("filter eggs");
    }
}
