package com.ktc.matgpt.domain.order;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Table(name = "order_tb")
@Entity
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long orderId;

    private Long userId;

    private String foodName;

    private int quantity;

    private LocalDateTime createdAt;

    @Builder
    public Order(Long id, Long orderId, Long userId, String foodName, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.createdAt = LocalDateTime.now();
    }

    public Order() {
    }
}
