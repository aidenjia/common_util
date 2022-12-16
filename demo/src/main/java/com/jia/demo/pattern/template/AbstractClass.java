package com.jia.demo.pattern.template;

public abstract class AbstractClass {
    public final void work() {
        //起床
        this.wake();
        //刷牙
        this.brush();
        //吃早饭
        this.breakfast();
        //交通工具
        this.transport();
        //睡觉
        this.sleep();
    }

    //步骤一样 直接实现
    public void wake() {
        System.out.println("起床...");
    }

    //步骤一样 直接实现
    public void brush() {
        System.out.println("刷牙...");
    }

    // 步骤不一样 (一个是吃面包 一个是喝牛奶)
    public abstract void breakfast();

    // 步骤不一样 (一个是开车 一个是坐地铁)
    public abstract void transport();

    // 步骤一样 直接实现
    public void sleep() {
        System.out.println("睡觉...");
    }
}
