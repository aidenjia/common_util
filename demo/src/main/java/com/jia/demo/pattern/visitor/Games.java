package com.jia.demo.pattern.visitor;

public class Games implements Computer{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void play() {
        System.out.println("play lol");
    }
}
