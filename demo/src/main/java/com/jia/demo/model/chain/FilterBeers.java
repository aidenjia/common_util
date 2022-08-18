package com.jia.demo.model.chain;

public class FilterBeers implements Filter{
    @Override
    public void doFilter(String data) {
        System.out.println("filter beers");
    }
}
