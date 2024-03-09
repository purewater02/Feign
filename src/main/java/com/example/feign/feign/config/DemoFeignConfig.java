package com.example.feign.feign.config;

import com.example.feign.feign.decoder.DemoFeignErrorDecoder;
import com.example.feign.feign.interceptor.DemoFeignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoFeignConfig {
  // Global config가 아닌 특정 클라이언트마다 다른 설정들을 모아둠.

  @Bean
  public DemoFeignInterceptor demoFeignInterceptor() {
    return DemoFeignInterceptor.of();
  }

  @Bean
  public DemoFeignErrorDecoder demoFeignErrorDecoder() {
    return DemoFeignErrorDecoder.of();
  }
}
