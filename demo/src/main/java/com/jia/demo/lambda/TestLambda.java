package com.jia.demo.lambda;

import java.util.List;

public class TestLambda {

    static class FuncClass2 implements FuncInterface{
        @Override
        public void funcInter() {
            System.out.println("I like Lambda1");
        }
    }

    public static void main(String[] args) {
        FuncInterface funcInterface=new FuncClass();
        funcInterface.funcInter();

        funcInterface=new FuncClass2();
        funcInterface.funcInter();

        class FuncClass3 implements FuncInterface{
            @Override
            public void funcInter() {
                System.out.println("I like Lambda2");
            }
        }
        funcInterface=new FuncClass3();
        funcInterface.funcInter();

        //匿名内部类
        funcInterface=new FuncInterface() {
            @Override
            public void funcInter() {
                System.out.println("I like Lambda3");
            }
        };
        funcInterface.funcInter();

        funcInterface=()->System.out.println("I like Lambda5");
        funcInterface.funcInter();

    }
}

interface FuncInterface {
    void funcInter();
}

class FuncClass implements FuncInterface{
    @Override
    public void funcInter() {
        System.out.println("I like Lambda");
    }
}


