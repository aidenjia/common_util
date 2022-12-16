package com.jia.demo.pattern.strategy;

public class StrategyC implements Strategy{
    @Override
    public void show() {
        System.out.println("C促销 满500元可兑换小礼品");
    }
}
