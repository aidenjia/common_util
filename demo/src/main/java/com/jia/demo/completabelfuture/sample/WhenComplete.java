package com.jia.demo.completabelfuture.sample;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * 当CompletableFuture的计算结果完成，或者抛出异常的时候，可以执行特定的Action
 * whenComplete 和 whenCompleteAsync 的区别：
 * whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。
 * whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行
 */
public class WhenComplete {
    public static void main(String[] args) throws Exception{

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            Integer i=Integer.valueOf(0);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if(new Random().nextInt()%2>=0) {
                 i =Integer.valueOf( 12/0);
            }
            System.out.println("run end ...");
            return i;
        });

        future.whenComplete(new BiConsumer<Integer, Throwable>() {
            @Override
            public void accept(Integer t, Throwable action) {
                System.out.println("执行完成！");
                if(null!=action){
                    System.out.println("throwable: "+action.toString());
                }

            }

        });


        TimeUnit.SECONDS.sleep(2);
    }
}
