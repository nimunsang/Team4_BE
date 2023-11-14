package com.ktc.matgpt.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderSequenceRepository orderSequenceRepository;

    @Transactional
    public Long save(Long userId, OrderRequest orderRequest) {

        OrderSequence orderSequence = orderSequenceRepository.findById(1L).orElseThrow(
                () -> new NoSuchElementException("OrderSequence가 존재하지 않습니다.")
        );


        for (OrderRequest.OrderDto orderDto : orderRequest.getOrderDtos()) {
            Order order = Order.builder()
                    .orderId(orderSequence.getSequence())
                    .userId(userId)
                    .foodName(orderDto.getFoodName())
                    .quantity(orderDto.getQuantity())
                    .build();

            orderRepository.save(order);
        }
        orderSequence.update();

        return orderSequence.getSequence() - 1;
    }

    public OrderResponse getOrder(Long userId, Long orderId) {
        List<Order> orders = orderRepository.findAllByOrderId(orderId);
        List<OrderResponse.OrderResponseDto> orderResponseDtos = orders.stream()
                .map(OrderResponse.OrderResponseDto::new)
                .toList();

        return new OrderResponse(userId, orderId, orderResponseDtos);
    }
}
