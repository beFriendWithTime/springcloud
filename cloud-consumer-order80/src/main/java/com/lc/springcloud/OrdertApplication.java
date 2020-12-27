package com.lc.springcloud;

import com.lc.myrlue.LoadBalanceRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration= LoadBalanceRule.class)
@MapperScan("com.lc.springcloud.dao")
public class OrdertApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdertApplication.class, args);
        System.out.println("===OrdertApplication.success===");
    }
}
