package com.lc.springcloud.controller;



import com.lc.springcloud.dto.CommonResult;
import com.lc.springcloud.dto.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/create")
    @PostMapping
    public CommonResult create(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/web/payment/create",payment,CommonResult.class);
    }

    @RequestMapping("/consumer/get/{id}")
    @GetMapping
    public CommonResult getPaymentById(@PathVariable  Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/web/payment/get/"+id,CommonResult.class);
    }

    @RequestMapping("/consumer/getForEntity/{id}")
    @GetMapping
    public CommonResult<Payment> getPaymentByIdForEntity(@PathVariable  Long id){
        ResponseEntity<CommonResult> data=restTemplate.getForEntity(PAYMENT_URL+"/web/payment/get/"+id,CommonResult.class);
        if(data.getStatusCode().is2xxSuccessful()){
            return  data.getBody();
        }
      return  new CommonResult(400,"请求失败");
    }

    @RequestMapping("/consumer/createForEntity")
    @PostMapping
    public CommonResult createForEntity(Payment payment){
        ResponseEntity<CommonResult> data=restTemplate.postForEntity(PAYMENT_URL+"/web/payment/create",payment,CommonResult.class);
        if(data.getStatusCode().is2xxSuccessful()){
            return  data.getBody();
        }
        return  new CommonResult(400,"请求失败");
    }
}
