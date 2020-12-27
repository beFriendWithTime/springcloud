package com.lc.springcloud.controller;



import com.lc.springcloud.dto.CommonResult;
import com.lc.springcloud.dto.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://cloud-payment-consul-service";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consul/consumer/create")
    @GetMapping
    public String create(){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }

}
