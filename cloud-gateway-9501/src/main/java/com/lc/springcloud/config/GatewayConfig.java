package com.lc.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator RouteLocator(RouteLocatorBuilder builder){
        return  builder.routes().route("path_route1",r->r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
    }
//    @Bean
//    public RouteLocator RouteLocator2(RouteLocatorBuilder builder){
//        return  builder.routes().route("path_route2",r->r.path("/ok").uri("http://localhost:8001/web/payment/hystrix/ok/1")).build();
//    }
}
