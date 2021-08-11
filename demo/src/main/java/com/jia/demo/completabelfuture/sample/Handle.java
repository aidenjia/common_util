package com.jia.demo.completabelfuture.sample;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Handle {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->{
            int i=10/0;
            return new Random().nextInt(10);
        }).handle((param,throwAble)->{
           int result=-1;
           if(null==throwAble){
               return param*2;
           }else {
               System.out.println(throwAble.getMessage());
           }
            return result;
        });
        System.out.println(future.get());
    }
}
