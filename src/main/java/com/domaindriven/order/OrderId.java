package com.domaindriven.order;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class OrderId implements Serializable {

    private Long orderId;

    protected OrderId() {}

    public String orderIdString() {
        return String.valueOf(orderId);
    }
}
