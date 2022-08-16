package com.jia.demo.model.adapter;

/**
 * 摩卡 Mocha 类 (具体装饰构件)
 */
public class Mocha extends CondimentDecorator{

    private final Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha ";
    }
}
