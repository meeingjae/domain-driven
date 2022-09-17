package com.domaindriven.order;

import javax.persistence.Embeddable;

@Embeddable
public class ShippingInfo {

    private String address;
    private String zipCode;
}
