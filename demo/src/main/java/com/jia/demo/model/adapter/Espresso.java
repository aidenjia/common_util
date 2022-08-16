package com.jia.demo.model.adapter;

/**
 * 浓咖啡 Espresso 类 (具体构件)
 */
public class Espresso extends Beverage{
    public Espresso(){
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 0;
    }
}
