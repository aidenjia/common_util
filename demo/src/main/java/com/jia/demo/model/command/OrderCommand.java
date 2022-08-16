package com.jia.demo.model.command;

public class OrderCommand implements Command{
    //持有接受者对象
    private SeniorChef receiver;

    private Order order;

    public OrderCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable()+"桌的订单：");
        for (String key : order.getFoodDic().keySet()) {
            receiver.makefood(order.getFoodDic().get(key),key);
        }
        System.out.println(order.getDiningTable()+"桌的饭弄好了");
    }
}
