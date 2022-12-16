package com.jia.demo.pattern.builder;

public class BenzBuilder extends CarBuilder{
    private Car car=new Car();

    @Override
    public void buildWheel() {
        car.setWheel("上好的车轮");
    }

    @Override
    public void buildShell() {
        car.setShell("奔驰外壳");
    }

    @Override
    public void buildEngine() {
        car.setEngine("奔驰产发动机");
    }

    @Override
    public void buildSteeringWheel() {
        car.setSteeringWheel("有奔驰标识的方向盘");
    }

    @Override
    public Car getCar() {
        return car;
    }
}
