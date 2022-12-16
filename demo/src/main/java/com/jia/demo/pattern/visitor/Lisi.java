package com.jia.demo.pattern.visitor;

public class Lisi implements Visitor{
    @Override
    public void visit(Games games) {
        games.play();
    }
    @Override
    public void visit(Photos photos) {
        photos.watch();
    }
}
