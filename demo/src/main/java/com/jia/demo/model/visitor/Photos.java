package com.jia.demo.model.visitor;

public class Photos implements Computer{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void watch() {
        System.out.println("watch scenery photo");
    }
}
