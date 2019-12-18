package com.jia.demo.spi;

public class MysqlRepository implements IRepository {
    @Override
    public void save(String data) {
        System.out.println("Save " + data + " to Mysql");
    }
}
