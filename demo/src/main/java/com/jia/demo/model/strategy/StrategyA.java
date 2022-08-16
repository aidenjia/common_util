package com.jia.demo.model.strategy;

public class StrategyA implements Strategy{
    @Override
    public void show() {
        System.out.println("A促销 买一送一");
    }
}
