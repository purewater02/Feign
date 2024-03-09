package com.example.feign.service;

import com.example.feign.feign.client.DemoFeignClient;
import com.example.feign.feign.common.dto.BaseRequestInfo;
import com.example.feign.feign.common.dto.BaseResponseInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {
  private final DemoFeignClient demoFeignClient;

  public ResponseEntity<BaseResponseInfo> get() {
    return demoFeignClient.callGet("CustomHeader", "CustomName", 1L);
  }

  public ResponseEntity<BaseResponseInfo> post(BaseRequestInfo request) {
    return demoFeignClient.callPost("CustomHeader", request);
  }

  public ResponseEntity<BaseResponseInfo> error() {
    return demoFeignClient.callError();
  }
}
