package com.jia.demo.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Computer> computers = new ArrayList<Computer>();

    public void action(Visitor visitor) {
        computers.forEach(c -> {
            c.accept(visitor);
        });
    }
    public void add(Computer computer) {
        computers.add(computer);
    }
}
