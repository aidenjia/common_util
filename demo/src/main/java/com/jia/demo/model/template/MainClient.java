package com.jia.demo.model.template;

public class MainClient {
    public static void main(String[] args) {
        //吃面包 坐公交
        System.out.println("周一");
        AbstractClass breakFast = new ConcreteClass_BreakFast();
        breakFast.work();

        System.out.println("========================");
        System.out.println("周五");
        AbstractClass transport = new ConcreteClass_Transport();
        transport.work();
    }
}
