package com.lc.spriongcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
    @Bean
    public  Logger.Level LogLevel(){
        return Logger.Level.FULL;//日志级别
    }
}
