package com.domaindriven.order;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class ShippingInfo {

    private String address;
    private String zipCode;

    protected ShippingInfo() {}

    public String address() {
        return address;
    }

    public String zipCode() {
        return zipCode;
    }
}
