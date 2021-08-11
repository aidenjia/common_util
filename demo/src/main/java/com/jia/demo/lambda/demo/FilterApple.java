package com.jia.demo.lambda.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterApple {
    public static void main(String[] args) {
        List<Apple> inventory=new ArrayList<>();
        Apple apple1=new Apple();
        apple1.setColor("GREEN");
        apple1.setWeight(80);
        inventory.add(apple1);

//        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
//            public boolean test(Apple a){
//                return "RED".equals(a.getColor());
//            }
//        });

        List<Apple> result =
                filterApples(inventory, (Apple apple) -> "GREEN".equals(apple.getColor()));
        System.out.println(result.size());

        //inventory.sort((a1,a2)->a1.getWeight().compareTo(a2.getWeight()));

    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }


}
