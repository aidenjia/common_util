package com.jia.demo.pattern.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class WxPay extends Pay{
    protected Logger logger = LoggerFactory.getLogger(WxPay.class);

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        logger.info("模拟微信渠道支付风控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            logger.info("模拟微信渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("模拟微信渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }
}