package com.lc.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    String paymentOk(Integer id);

    String paymentTimeout(Integer id);

    String paymentTimeout_Handler(Integer id);

    String paymentCircuitBreaker(Integer id);
}
