package com.jia.demo.model.strategy;

/**
 * @Classname SalesMan
 * @Description 定义环境角色 用于连接上下文 把促销活动推销给顾客
 */
public class SalesMan {
    //持有抽象策略角色的引用
    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    //展示促销活动
    public void salesManShow() {
        strategy.show();
    }
}
