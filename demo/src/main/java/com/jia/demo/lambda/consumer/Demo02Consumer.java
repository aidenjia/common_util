package com.jia.demo.lambda.consumer;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo02Consumer {
    public static void main(String[] args) {
        Consumer<String> nameConsumer = s -> System.out.println(s);
        nameConsumer.accept("Mahesh");
        nameConsumer.accept("Krishna");

        Function<String,String> stringFunction = item->item + "-world";
        System.out.println(stringFunction.apply("hello"));

        Predicate<String> stringPredicate = item-> item.equals("hello");

        Supplier<String> stringSupplier = ()-> "hello";

    }

}
