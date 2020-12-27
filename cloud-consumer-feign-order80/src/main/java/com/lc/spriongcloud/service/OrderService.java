package com.lc.spriongcloud.service;

import com.lc.springcloud.dto.CommonResult;
import com.lc.springcloud.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderService {
//    @RequestMapping("/web/payment/get/{id}")
    @GetMapping("/web/payment/get/{id}")
    CommonResult<Payment> getPaymentByFeign(@PathVariable("id") Long id);

    @GetMapping("/web/payment/feign/timeout")
    String  feignTimeOut();
 }
