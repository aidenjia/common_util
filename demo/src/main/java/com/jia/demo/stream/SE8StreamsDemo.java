package com.jia.demo.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SE8StreamsDemo {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("Java", "Magazine", "is",
                "the", "best");
        Map<String, Long> letterToCount =
                words.map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .collect(groupingBy(identity(), counting()));

    }
}
