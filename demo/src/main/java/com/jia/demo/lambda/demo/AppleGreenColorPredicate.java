package com.jia.demo.lambda.demo;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "GREEN".equals(apple.getColor());
    }
}
