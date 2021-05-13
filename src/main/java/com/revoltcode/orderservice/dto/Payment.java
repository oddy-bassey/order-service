package com.revoltcode.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;

    @Column
    private String paymentStatus;

    @Column
    private String transactionId;

    @Column
    private int orderId;

    @Column
    private double amount;
}
