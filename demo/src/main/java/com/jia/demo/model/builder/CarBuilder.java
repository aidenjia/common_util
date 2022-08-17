package com.jia.demo.model.builder;

public abstract class CarBuilder {
    //造车轮的方法，因为实际上车轮可能是一个复杂对象
    public abstract void buildWheel();
    //造外壳的方法
    public abstract void buildShell();
    //造引擎的方法
    public abstract void buildEngine();
    //造方向盘的方法
    public abstract void buildSteeringWheel();
    public abstract Car getCar();
}
