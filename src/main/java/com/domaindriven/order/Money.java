package com.domaindriven.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Money {

    private Long money;

    protected Money() {}

    public String moneyString() {
        return String.valueOf(money);
    }

    public Long getMoney() {
        return this.money;
    }
}
