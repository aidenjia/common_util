package com.jia.demo.abstractqueuedSynchronizer;

import com.sun.jdi.ClassNotPreparedException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExceptionTest {
//    public static void main(String[] args) throws InterruptedException {
//        try {
//            throw new RuntimeException("thread run failed:" + Thread.currentThread().getName());
//        } catch (RuntimeException e) {
//            e.getCause();
//            System.out.println(e.getMessage());
//        }
//        System.out.println("continue main thread");
//        Thread.sleep(2000);
//        System.out.println("end ......");
//    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future future = es.submit(() -> {
            throw new ClassNotPreparedException("eeeeeee");
        });
        try {
            future.get();
        } catch (Throwable e) {
            if(e.getCause() instanceof ClassNotPreparedException){
                System.out.println(e.getMessage());
            }
            future.cancel(true);
            es.shutdown();
        }
    }
}
