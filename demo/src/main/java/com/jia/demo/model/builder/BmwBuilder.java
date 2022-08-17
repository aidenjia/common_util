package com.jia.demo.model.builder;

public class BmwBuilder extends CarBuilder{
    private Car car=new Car();

    @Override
    public void buildWheel() {
        car.setWheel("上好的车轮");
    }

    @Override
    public void buildShell() {
        car.setShell("宝马外壳");
    }

    @Override
    public void buildEngine() {
        car.setEngine("宝马产发动机");
    }

    @Override
    public void buildSteeringWheel() {
        car.setSteeringWheel("有宝马标识的方向盘");
    }

    @Override
    public Car getCar() {
        return car;
    }
}
