package com.jia.demo.model.strategy;

import java.util.Optional;

public class ClientMain {
    public static void main(String[] args) {
        SalesMan salesMan = new SalesMan(new StrategyA());
        //儿童节
        salesMan.salesManShow();
        System.out.println("=======================");
        //劳动节
        salesMan.setStrategy(new StrategyB());
        salesMan.salesManShow();
        System.out.println("=======================");
        //端午节
        salesMan.setStrategy(new StrategyC());
        salesMan.salesManShow();

    }
}
