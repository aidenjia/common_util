package com.jia.demo.model.visitor;

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
