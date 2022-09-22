package com.domaindriven.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Email {

    private final String email;

    public String getEmail() {
        return this.email;
    }
}
