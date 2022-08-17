package com.jia.demo.model.builder;

public class ClientMain {
    public static void main(String[] args) {
        CarBuilder builder1=new BmwBuilder();
        CarBuilder builder2=new BenzBuilder();
        CarDirector carDirector = new CarDirector(builder1);
        Car car = carDirector.build();
        System.out.println(car);
    }
}
