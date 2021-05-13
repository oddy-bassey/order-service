package com.revoltcode.orderservice.service;

import com.revoltcode.orderservice.dto.Payment;
import com.revoltcode.orderservice.dto.TransactionRequest;
import com.revoltcode.orderservice.dto.TransactionResponse;
import com.revoltcode.orderservice.entity.Order;
import com.revoltcode.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderService(OrderRepository orderRepository, RestTemplateBuilder restTemplateBuilder) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){

        Order order = orderRepository.save(transactionRequest.getOrder());
        Payment payment = transactionRequest.getPayment();

        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        //perform REST call to payment api and add order id
        Payment paymentResponse = restTemplate.postForObject("http://localhost:9191/payment/doPayment", payment, Payment.class);



        String message = (paymentResponse.getPaymentStatus().equals("success")? "Payment processing successful and order placed" : "failure in payment API, order added to cart");
        return TransactionResponse.builder()
                .order(order)
                .payment(paymentResponse)
                .message(message)
                .build();
    }
}
