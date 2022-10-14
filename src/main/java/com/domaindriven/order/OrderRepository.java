package com.domaindriven.order;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderId> {

    List<Order> findAll(Specification<Order> spec);

    List<Order> findFirst10ByOrderId(
            OrderId orderId); // 조회 결과 중 처음부터 N 개의 결과가 필요할 경우 = Firstn 형식 사용 --> 모든 조회 로직을 처리한 후 n개만 응답

    List<Order> findFirstByOrderId(OrderId orderId); // 조회 결과 첫 원소 리턴

    @Query(value = " SELECT new com.domaindriven.order.OrderView(o.orderId, o.money) "
                   + " FROM Order o "
                   + "WHERE o.orderId = :orderId")
    Order findOrderDynamic(@Param(value = "orderId") OrderId orderId);
}
