package com.ktc.matgpt.domain.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderRequest {

    List<OrderDto> orderDtos;

    @Setter
    @Getter
    public static class OrderDto {
        String foodName;
        int quantity;

        public OrderDto(String foodName, int quantity) {
            this.foodName = foodName;
            this.quantity = quantity;
        }
    }
}
