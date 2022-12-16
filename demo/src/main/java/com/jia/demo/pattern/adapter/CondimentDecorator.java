package com.jia.demo.pattern.adapter;

/**
 * 调料 CondimentDecorator 抽象类 (抽象装饰构件)
 */
public abstract class CondimentDecorator  extends Beverage{
    @Override
    public abstract String getDescription();
}
