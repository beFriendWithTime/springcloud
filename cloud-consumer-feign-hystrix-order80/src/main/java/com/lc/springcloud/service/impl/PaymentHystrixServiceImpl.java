package com.lc.springcloud.service.impl;

import com.lc.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    protected String  Impl_Global_FallbackMethod(){
        return "-----PaymentHystrixServiceImpl.Impl_Global_FallbackMethod统一服务降级-------";
    }

    @Override
    public String paymentOk(Integer id) {
        return Impl_Global_FallbackMethod();
    }

    @Override
    public String paymentTimeout(Integer id) {
        return Impl_Global_FallbackMethod();
    }
}
