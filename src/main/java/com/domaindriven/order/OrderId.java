package com.domaindriven.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class OrderId implements Serializable {

    private static final long serialVersionUID = 6505186025845150423L;
    @Column(name = "order_id")
    private Long orderId;

    protected OrderId() {}

    public String orderIdString() {
        return String.valueOf(orderId);
    }
}
