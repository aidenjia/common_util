package com.jia.demo.abstractqueuedSynchronizer;

public class CountDownLatchTest {
    public static void main(String[] args) {
        final java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(2);
        new Thread(()->{
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
