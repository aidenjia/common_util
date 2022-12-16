package com.jia.demo.pattern.memento;

import java.util.LinkedList;
import java.util.List;

public class Caretaker {
    private List<Memento> mementos = new LinkedList<>();

    public Memento get() {
        return mementos.remove(0);
    }

    public void add(Memento memento) {
        mementos.add(0, memento);
    }
}
