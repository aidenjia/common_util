package com.jia.demo.virtual_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadMain {

  public static void main(String[] args) throws InterruptedException {
    Runnable runnable2 = () -> System.out.println("Thread name:"+ Thread.currentThread().getName());
    try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < 100; i++) {
        executorService.submit(runnable2);
      }
    }
    Thread.sleep(5000);
  }

}
