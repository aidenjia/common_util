package com.jia.demo.model.memento;

public class ClientMain {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("状态1");
        caretaker.add(originator.save());
        originator.setState("状态2");
        caretaker.add(originator.save());
        originator.setState("状态3");
        caretaker.add(originator.save());
        originator.restore(caretaker.get());
        System.out.println(originator.getState());
        originator.restore(caretaker.get());
        System.out.println(originator.getState());
        originator.restore(caretaker.get());
        System.out.println(originator.getState());
    }
}
