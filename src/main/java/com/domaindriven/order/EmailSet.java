package com.domaindriven.order;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailSet {

    private Set<Email> emailSet = new HashSet<>();

    public void addEmail(String email) {
        emailSet.add(new Email(email));
    }

    public Set<Email> getEmailSet() {
        return this.emailSet;
    }

    public String getEmailString() {
        return this.emailSet.stream()
                .map(Email::getEmail)
                .collect(Collectors.joining(", "));
    }
}
