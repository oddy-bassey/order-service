package com.revoltcode.orderservice.controller;

import com.revoltcode.orderservice.dto.Payment;
import com.revoltcode.orderservice.dto.TransactionRequest;
import com.revoltcode.orderservice.dto.TransactionResponse;
import com.revoltcode.orderservice.entity.Order;
import com.revoltcode.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){

        return orderService.saveOrder(transactionRequest);
    }
}
