package com.ktc.matgpt.domain.order;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "order_sequence_tb")
@Entity
public class OrderSequence {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long sequence;

    public void update() {
        this.sequence = getSequence() + 1;
    }
}
