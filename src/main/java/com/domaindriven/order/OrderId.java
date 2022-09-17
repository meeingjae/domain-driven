package com.domaindriven.order;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderId implements Serializable {

    public Long orderId;
}
