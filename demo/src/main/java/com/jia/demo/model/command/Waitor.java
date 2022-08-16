package com.jia.demo.model.command;

import java.util.ArrayList;

public class Waitor {

    //可以持有很多命令对象
    private ArrayList<Command> commands;

    public Waitor() {
        commands = new ArrayList<Command>();
    }

    public void setCommands(Command cmd) {
        commands.add(cmd);
    }

    //发出命令 订单来了 大厨师开始执行命令
    public void orderUp() {
        System.out.println("来活了...");
        for (int i = 0; i < commands.size(); i++) {
            Command cmd = commands.get(i);
            if (cmd != null) {
                cmd.execute();
            }
        }
    }

}
