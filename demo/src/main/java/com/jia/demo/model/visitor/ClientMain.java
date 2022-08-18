package com.jia.demo.model.visitor;

public class ClientMain {
    public static void main(String[] args) {
        // 创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        // 给结构增加一个节点
        os.add(new Games());
        // 给结构增加一个节点
        os.add(new Photos());
        // 创建一个访问者
        Visitor visitor = new ZhangSan();
        os.action(visitor);
    }
}
