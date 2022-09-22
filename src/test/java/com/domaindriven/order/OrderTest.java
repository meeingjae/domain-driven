package com.domaindriven.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    void saveAndFind() {
        orderRepository.saveAll(Arrays.asList(
                new Order(
                        new OrderId(1L),
                        new ShippingInfo("address", "zipCode"),
                        new Money(1000L),
                        Collections.singletonList(new OrderLine(
                                new Money(100L),
                                3)),
                        new EmailSet(Set.of(
                                new Email("email1@naver.com"),
                                new Email("email2@naver.com")
                        ))),
                new Order(
                        new OrderId(2L),
                        new ShippingInfo("address2", "zipCode2"),
                        new Money(2000000L),
                        Collections.singletonList(new OrderLine(
                                new Money(100L),
                                3)),
                        new EmailSet(Set.of(
                                new Email("email3@naver.com"),
                                new Email("email4@naver.com")
                        ))
                )));

        List<Order> order = orderRepository.findAll();
        order.forEach(System.out::println);
        assertThat(order).hasSize(2);
    }
}

