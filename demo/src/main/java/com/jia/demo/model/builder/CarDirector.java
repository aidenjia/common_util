package com.jia.demo.model.builder;

public class CarDirector {
    private CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }
    public Car build(){
        builder.buildEngine();
        builder.buildShell();
        builder.buildSteeringWheel();
        builder.buildWheel();
        return builder.getCar();
    }
}

