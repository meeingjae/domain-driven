package com.domaindriven.order;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class ProductId {

    private Long productId;

    protected ProductId() {}
}
