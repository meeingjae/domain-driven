package com.domaindriven.order;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
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
    private OrderId orderId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "address")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zipcode"))
    })
    private ShippingInfo shippingInfo;

    @Convert(converter = MoneyConverter.class)
    private Money money;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "D_ORDER_LINE", joinColumns = @JoinColumn(name = "order_id"))
    @OrderColumn(name = "order_line_idx")
    private List<OrderLine> orderLines;

    @Convert(converter = EmailSetConverter.class)
    private EmailSet emailSet;

    @Override
    public String toString() {
        return "orderId:" + orderId.orderIdString() + " address:" + shippingInfo.address() +
               " zipCode:" + shippingInfo.zipCode() + " money:" + money.moneyString() +
               " email: " + emailSet.getEmailString();
    }
}
