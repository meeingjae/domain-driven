package com.domaindriven.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

@SpringBootTest
public class OrderTest {

    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    public void before() {
        orderRepository.saveAll(Arrays.asList(
                new Order(
                        new OrderId(1L),
                        new ShippingInfo("address", "zipCode"),
                        new Money(1000L),
                        Collections.singletonList(new OrderLine(
                                new ProductId(1L),
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
                                new ProductId(2L),
                                new Money(100L),
                                3)),
                        new EmailSet(Set.of(
                                new Email("email3@naver.com"),
                                new Email("email4@naver.com")
                        ))
                )));
    }

    @Test
    void saveAndFind() {

        List<Order> order = orderRepository.findAll();
        order.forEach(System.out::println);
        assertThat(order).hasSize(2);
    }

    @Test
    void specTest() {
        Specification<Order> orderIdSepc = OrderSpec.orderIdSpec(new OrderId(1L));
        Specification<Order> orderMoneySpec = OrderSpec.orderMoneySpec(new Money(1000L));
        List<Order> orders = orderRepository.findAll(orderIdSepc.and(orderMoneySpec));
        orders.forEach(it -> System.out.println(it.toString()));
        assertThat(orders).hasSize(1);
    }
}

