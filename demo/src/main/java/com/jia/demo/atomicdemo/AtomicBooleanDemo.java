package com.jia.demo.atomicdemo;

import java.util.concurrent.TimeUnit;

/**
 * Java的java.util.concurrent.atomic这个包下提供了很多的原子性操作的api，可供在多线程中保证操作的原子性，不会发生线程不安全的操作
 */
public class AtomicBooleanDemo {
    /**
     * 实现某个时间段只能有一个工作人员进行工作的实例，线程不安全代码如下：
     */
    //设置某段时间内只能有一个工作人员进行工作，其他的只能放弃工作的机会
    private static boolean exists = false;

    class BarWorker implements Runnable {
        private String name;

        public BarWorker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            if (!exists) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                exists = true;
                System.out.println(name + " enter");
                try {
                    System.out.println(name + " working");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " leave");
                exists = false;
            } else {
                System.out.println(name + " give up");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("test1");
        System.out.println("test2");
    }
}

