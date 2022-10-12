package com.domaindriven.order;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class OrderSpec {

    public static Specification<Order> orderIdSpec(OrderId orderId) {
        return (Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.equal(root.get("orderId"), orderId);
    }

    public static Specification<Order> orderMoneySpec(Money money) {
        return (Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.equal(root.get("money"), money);
    }
}
