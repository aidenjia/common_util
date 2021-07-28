package com.jia.demo.optionaldemo;

import java.util.Optional;

public class Car {
    private Optional<Insurance> insurance;
    public Optional<Insurance> getInsurance() { return insurance; }
}
