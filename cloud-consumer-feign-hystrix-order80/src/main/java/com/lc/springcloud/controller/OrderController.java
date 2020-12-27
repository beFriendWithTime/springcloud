package com.lc.springcloud.controller;


import com.lc.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_Global_FallbackMethod")
public class OrderController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    @HystrixCommand
    public  String orderHystrixOk(@PathVariable Integer id){
//        int i=10/0;
        return  paymentHystrixService.paymentOk(id);
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "oderHystrix_Handler",commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
//    @HystrixCommand
    public  String orderHystrixTimeout(@PathVariable Integer id){
        log.info("order调用Start:"+new Date());
//        int i=10/0;
        return  paymentHystrixService.paymentTimeout(id);
    }

    @GetMapping("/consumer/hystrix/error/{id}")
    @HystrixCommand
    public  String orderHystrixError(@PathVariable Integer id){
        int i=10/0;
        return  paymentHystrixService.paymentTimeout(id);
    }
    //timeOut方法的服务降级
    public String oderHystrix_Handler(@PathVariable Integer id){
        log.info("Order服务降级时间："+new Date());
        return "order服务器繁忙,请求失败--->服务降级处理";
    }

    //通用服务降级方法
    public String paymentInfo_Global_FallbackMethod(){
        return "全局服务降级处理";
    }
}
