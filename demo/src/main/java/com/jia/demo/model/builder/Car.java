package com.jia.demo.model.builder;

public class Car {
    //车轮
    private String wheel;
    //外壳
    private String shell;
    //发动机
    private String engine;
    //方向盘
    private String steeringWheel;

    @Override
    public String toString() {
        return "Car{" +
                "wheel='" + wheel + '\'' +
                ", Shell='" + shell + '\'' +
                ", engine='" + engine + '\'' +
                ", steeringWheel='" + steeringWheel + '\'' +
                '}';
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
