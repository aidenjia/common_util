package com.jia.demo.model.template;

public class ConcreteClass_Transport extends AbstractClass{
    @Override
    public void breakfast() {
        System.out.println("喝牛奶...");
    }

    @Override
    public void transport() {
        System.out.println("乘地铁...");
    }
}
