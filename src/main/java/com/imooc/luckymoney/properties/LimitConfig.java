package com.imooc.luckymoney.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@ConfigurationProperties(prefix = "limit" )
public class LimitConfig {
//书写配置
    private BigDecimal minMoney;

    private  BigDecimal maxMoney;

    private  String description;


    public BigDecimal getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(BigDecimal maxMoney) {
        this.maxMoney = maxMoney;
    }

    public BigDecimal getMinMoney() {
        return minMoney;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinMoney(BigDecimal minMoney) {
        this.minMoney = minMoney;
    }
}
