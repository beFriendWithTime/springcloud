package com.lc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lc.springcloud.dao")
public class OrdertApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdertApplication.class, args);
        System.out.println("===OrdertApplication.success===");
    }
}
