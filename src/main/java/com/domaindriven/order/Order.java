package com.domaindriven.order;

import javax.persistence.Access;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "D_ORDER")
public class Order {

    @EmbeddedId
    @AttributeOverride(
            name = "orderId", column = @Column(name = "ORDER_ID")
    )
    private OrderId orderId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "ADDRESS")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "ZIPCODE"))
    })
    private ShippingInfo shippingInfo;

    @Override
    public String toString() {
        return "orderId:" + orderId.orderIdString() + " address:" + shippingInfo.address() +
               " zipCode:" + shippingInfo.zipCode();
    }
}
