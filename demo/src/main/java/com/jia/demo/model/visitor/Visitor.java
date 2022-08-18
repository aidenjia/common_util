package com.jia.demo.model.visitor;

public interface Visitor {
    void visit(Games games);
    void visit(Photos photos);
}
