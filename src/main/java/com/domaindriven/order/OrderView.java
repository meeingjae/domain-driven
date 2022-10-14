package com.domaindriven.order;

import lombok.Getter;

/**
 * Order 객체의 동적 조회 인스턴스
 */
@Getter
public class OrderView {

    private String orderId;
    private String money;

    public OrderView(OrderId orderId, Money money) {
        this.orderId = orderId.orderIdString();
        this.money = money.moneyString();
    }
}
