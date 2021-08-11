package com.jia.demo.completabelfuture.sample;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * 当一个线程依赖另一个线程时，可以使用 thenApply 方法来把这两个线程串行化
 */
public class ThenApply {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(()->{
            long result = new Random().nextInt(100);
            System.out.println("result1="+result);
            return result;
        }).thenApply(t->{
            long result = t*5;
            System.out.println("result2="+result);
            return result;
        });
        long result = future.get();
        System.out.println(result);
    }
}
