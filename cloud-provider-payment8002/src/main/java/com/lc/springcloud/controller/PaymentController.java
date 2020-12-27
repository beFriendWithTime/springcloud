package com.lc.springcloud.controller;


import com.lc.springcloud.dto.CommonResult;
import com.lc.springcloud.dto.Payment;
import com.lc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/test")
    @GetMapping
    public void test() {
        System.out.println("测试成功");
    }

    @RequestMapping("/payment/get/{id}")
    @GetMapping
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询：{}", payment);
        if (!ObjectUtils.isEmpty(payment)) {
            return new CommonResult(200, "查询成功,port:" + serverPort, payment);
        }
        return new CommonResult(404, "查询失败，查询结果为空", null);
    }

    @RequestMapping("/payment/create")
    @PostMapping
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("创建结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,port:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/payment/feign/timeout")
    public String feignTimeOut() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Success";
    }
}
