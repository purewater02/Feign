package com.example.feign.feign.config;

import com.example.feign.feign.interceptor.DemoFeignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoFeignConfig {

  @Bean
  public DemoFeignInterceptor demoFeignInterceptor() {
    return DemoFeignInterceptor.of();
  }
}
