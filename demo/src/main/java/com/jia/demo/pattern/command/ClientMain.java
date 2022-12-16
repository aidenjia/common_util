package com.jia.demo.pattern.command;

public class ClientMain {
    public static void main(String[] args) {
        //创建order
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.getFoodDic().put("西红柿炒鸡蛋", 1);
        order1.getFoodDic().put("罐装可乐", 2);
        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.getFoodDic().put("酸溜土豆丝", 1);
        order2.getFoodDic().put("王老吉", 1);
        //创建接受者
        SeniorChef receiver = new SeniorChef();
        //将订单和接受者封装成命令对象
        OrderCommand cmd1 = new OrderCommand(receiver, order1);
        OrderCommand cmd2 = new OrderCommand(receiver, order2);
        //创建调用者 waitor
        Waitor invoke = new Waitor();
        invoke.setCommands(cmd1);
        invoke.setCommands(cmd2);
        //将订单给柜台 呼叫厨师
        invoke.orderUp();

    }
}
