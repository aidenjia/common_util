package com.jia.demo.model.strategy;

public class StrategyB implements Strategy {
    @Override
    public void show() {
        System.out.println("B促销 满100减20");
    }
}
