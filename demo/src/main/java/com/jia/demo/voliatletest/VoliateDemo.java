package com.jia.demo.voliatletest;

import java.util.concurrent.TimeUnit;

public class VoliateDemo {
    /**
     * 1 验证volatile的可见性
     *   1.1.假如int number=0；number变量之前根本没有添加volatile关键字修饰 没有可见性
     *   1.2 添加了volatile可以解决可见性问题
     *
     * 2 验证volatile不保证原子性
     *  2.1 原子性指的是什么意思？
     *     不可分割 完整性 也即某个线程正在做某个具体业务时 中间不可以被加塞或者分割。 需要整体完整要么同时成功 要么同时失败。
     *  2.2 是否可以保证原子性的案例
     *
     * @param args
     */
    public static void main(String[] args) {
       // seyOkByVolatile();

        MyData myData  =  new MyData();//资源类
        for (int i = 1; i <20 ; i++) {
            new Thread(() -> {
                for (int j = 1; j <1000 ; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }
        //需要等待上面20个线程都全部计算完成后 再用mian线程取得最终的结果值看是多少？
        while(Thread.activeCount() >2 ){//说明线程还没有算完
            Thread.yield();//礼让线程
        }
        System.out.println(Thread.currentThread().getName()+"\t int type,finally number value:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type,finally number value:"+myData.atomicInteger);
    }
    //volatile可以保证可见性。 及时通知其他线程 主物理内存的值已经修改
    private static void seyOkByVolatile() {
        MyData myData  =  new MyData();//资源类
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            //暂停一会线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t updated number value:" + myData.number);
        },"AAA").start();
        while (myData.number==0){
            //mian线程就一直再这里等待循环直到number值不在等于零
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }

}
