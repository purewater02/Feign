package com.example.feign.controller;

import com.example.feign.feign.common.dto.BaseRequestInfo;
import com.example.feign.feign.common.dto.BaseResponseInfo;
import com.example.feign.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
  private final DemoService demoService;

  @GetMapping("/get")
  public ResponseEntity<BaseResponseInfo> getController() {
    return demoService.get();
  }

  @PostMapping("/post")
  public ResponseEntity<BaseResponseInfo> postController() {
    return demoService.post(BaseRequestInfo.builder().name("testName").age(10L).build());
  }

  @GetMapping("/error")
  public ResponseEntity<BaseResponseInfo> errorDecoderController() {
    return demoService.error();
  }
}
