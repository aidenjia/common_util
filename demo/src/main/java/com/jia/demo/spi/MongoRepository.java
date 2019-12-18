package com.jia.demo.spi;

public class MongoRepository implements IRepository{
    @Override
    public void save(String data) {
        System.out.println("Save " + data + " to Mongo");
    }
}
