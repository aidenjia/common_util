package com.jia.demo.model.adapter;

/**
 * 豆浆 Soy 类 (具体装饰构件)
 */
public class Soy extends CondimentDecorator{

    private final Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.1 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy ";
    }
}
