package com.jia.demo.completabelfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1=CompletableFuture.supplyAsync(()->"hello ");
        CompletableFuture<String> future2=future1.thenApply(x->x+"world");

        System.out.println(future2.get());

    }
}
