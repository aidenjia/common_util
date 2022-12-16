package com.jia.demo.pattern.adapter;

/**
 * 饮料 Beverage 抽象类 (抽象构件)
 */
public abstract class Beverage {
    String description = "Unknown Beverage";
    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
