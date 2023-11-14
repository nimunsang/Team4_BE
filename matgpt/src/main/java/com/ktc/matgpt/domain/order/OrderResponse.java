package com.ktc.matgpt.domain.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderResponse {

    Long userId;
    Long orderId;
    List<OrderResponseDto> orders;

    @Setter
    @Getter
    public static class OrderResponseDto {
        String foodName;
        int quantity;

        public OrderResponseDto(Order order) {
            this.foodName = order.getFoodName();
            this.quantity = order.getQuantity();
        }
    }

    public OrderResponse(Long userId, Long orderId, List<OrderResponseDto> orderResponseDtos) {
        this.userId = userId;
        this.orderId = orderId;
        this.orders = orderResponseDtos;
    }
}
