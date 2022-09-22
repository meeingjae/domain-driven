package com.domaindriven.order;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;

public class EmailSetConverter implements AttributeConverter<EmailSet, String> {
    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
        return attribute.getEmailSet().stream()
                        .map(Email::getEmail)
                        .collect(Collectors.joining(","));
    }

    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
        return new EmailSet(Arrays.stream(dbData.split(","))
                                  .map(Email::new)
                                  .collect(Collectors.toSet()));
    }
}
