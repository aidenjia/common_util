package com.jia.demo.model.template;

public class ConcreteClass_BreakFast extends AbstractClass{

    @Override
    public void breakfast() {
        System.out.println("吃面包...");
    }

    @Override
    public void transport() {
        System.out.println("坐公交...");
    }
}
