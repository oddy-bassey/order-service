package com.revoltcode.orderservice.dto;

import com.revoltcode.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

    private Order order;
    private Payment payment;
    private String message;
}
