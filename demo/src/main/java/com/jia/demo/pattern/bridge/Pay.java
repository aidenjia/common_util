package com.jia.demo.pattern.bridge;

import java.math.BigDecimal;

public abstract class Pay {

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uerId, String tradedId, BigDecimal amount);
}