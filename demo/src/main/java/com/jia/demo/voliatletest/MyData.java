package com.jia.demo.voliatletest;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }
    //注意 此时number不保证原子性
    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger=new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }

}
