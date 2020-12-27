package com.lc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lc.springcloud.dao")
public class Payment8006Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8006Application.class, args);
        System.out.println("===Payment8006Application.success===");
    }
}
