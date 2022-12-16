package com.jia.demo.pattern.chain;

public class FilterEgg implements Filter{
    @Override
    public void doFilter(String data) {
        System.out.println("filter eggs");
    }
}
