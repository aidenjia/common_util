package com.jia.demo.completabelfuture.sample;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenAccept {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(()->{
            return new Random().nextInt(10);
        }).thenAccept(integer -> {
            System.out.println(integer);
        });
        future.get();
    }
}
