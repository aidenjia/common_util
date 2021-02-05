package com.jia.demo.completabelfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureComplete {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * complete 方法将future状态置为已完成,并且将参数注入,但如果这个future已经完成了,则
         * 不会产生任何变化
         */
        CompletableFuture future = CompletableFuture.supplyAsync(()-> "begin");
        future.complete("123");
        System.out.println(future.get());
     //   future.complete("345");
        System.out.println(future.get());
    }
}
