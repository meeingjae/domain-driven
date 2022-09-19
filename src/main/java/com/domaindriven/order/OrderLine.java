package com.domaindriven.order;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class OrderLine {

    // index 2 out of bounds for length 2 Exception. 이유가 뭘까?
    @Embedded
    @AttributeOverride(name = "productId", column = @Column(name = "product_id"))
    private ProductId productId;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    @Column(name = "amount")
    private int amount;

    protected OrderLine() {}
}
