package com.jia.demo.lambda.demo;

import java.util.Comparator;

public class ComparatorDemo {

    public static void main(String[] args) {
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }
        };

        Comparator<Apple> byWeight2=(a1,a2)->a1.getWeight().compareTo(a2.getWeight());
    }
}
