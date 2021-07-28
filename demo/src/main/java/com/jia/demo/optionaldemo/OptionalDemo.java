package com.jia.demo.optionaldemo;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Person person=new Person();
        Optional<Person> optPerson = Optional.of(person);
//        Optional<String> name =
//                optPerson.map(Person::getCar)
////                        .map(Car::getInsurance)
////                       .map(Insurance::getName);
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
