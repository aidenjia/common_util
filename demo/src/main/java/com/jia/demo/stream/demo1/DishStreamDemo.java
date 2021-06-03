package com.jia.demo.stream.demo1;

import com.jia.demo.stream.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DishStreamDemo {
    public static void main(String[] args) {
        Dish.menu.stream().filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName).limit(3).collect(toList());


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs=numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());

        pairs.forEach(item->System.out.println(item));
    }
}
