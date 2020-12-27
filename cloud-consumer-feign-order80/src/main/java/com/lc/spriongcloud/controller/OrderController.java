package com.lc.spriongcloud.controller;

import com.lc.springcloud.dto.CommonResult;
import com.lc.spriongcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("/consumer/get/{id}")
    @GetMapping
    public CommonResult getPaymentByFeign(@PathVariable Long id) {
        return  orderService.getPaymentByFeign(id);
    }

    @RequestMapping("/consumer/payment/feign/timeout")
    @GetMapping
    public String feignTimeout() {
        //feign默认连接超时时间是1s:若超过1s则会报timeout
        return  orderService.feignTimeOut();
    }
}
