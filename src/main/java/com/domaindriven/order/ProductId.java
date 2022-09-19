package com.domaindriven.order;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class ProductId {

    private long productId;

    protected ProductId() {}
}
