package com.jia.demo.pattern.visitor;

public interface Visitor {
    void visit(Games games);
    void visit(Photos photos);
}
