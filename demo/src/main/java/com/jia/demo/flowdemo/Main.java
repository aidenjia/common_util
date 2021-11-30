package com.jia.demo.flowdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Flow;

public class Main {

    public static void main(String[] args) {
        try {
            ExceptionTest();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void ExceptionTest() throws IOException {
        try (FileInputStream fis = new FileInputStream("D:\\file.txt")) {
           // throw new ExtractionException("EEEEEE");
        } finally {
            System.out.println(2);
        }
    }

    private static Flow.Publisher<TempInfo> getTemperatures(String town) {
        return subscriber -> subscriber.onSubscribe(
                new TempSubscription(subscriber, town));
    }
}
