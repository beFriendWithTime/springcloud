package com.lc.springcloud.service.impl;

import com.lc.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentOk(Integer id) {
        return "线程池名称：" + Thread.currentThread().getName() + ",paymentId:" + id + ",服务Ok";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentTimeout_Handler", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentTimeout(Integer id) {
//        int a=10/0;
//        try {
//            TimeUnit.SECONDS.sleep(6);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池名称：" + Thread.currentThread().getName() + ",paymentId:" + id + ",服务Timeout";
    }

    public String paymentTimeout_Handler(Integer id){
        return  "Payment服务器繁忙,请稍候再试";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "5"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "80")
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        log.info("调用服务成功,id:"+id+":"+ UUID.randomUUID());
        return "payment服务访问成功";
    }

    //服务熔断 兜底方法
    public String paymentCircuitBreaker_fallback(Integer id){
        log.info("触发服务熔断，服务禁止访问");
        return "触发服务熔断，服务禁止访问";
    }

}
