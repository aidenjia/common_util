package com.jia.demo.pattern.adapter;

/**
 * 黑咖啡 HouseBlend 类 (具体构件)
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee ";
    }
    @Override
    public double cost() {
        return 0.80;
    }
}
