package com.example.feign.controller;

import com.example.feign.feign.common.dto.BaseRequestInfo;
import com.example.feign.feign.common.dto.BaseResponseInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/target-server")
public class TargetController {

  @GetMapping("/get")
  public BaseResponseInfo demoGet(
      @RequestHeader("CustomHeaderName") String header,
      @RequestParam("name") String name,
      @RequestParam("age") Long age) {
    return BaseResponseInfo.builder().header(header).name(name).age(age).build();
  }

  @PostMapping("/post")
  public BaseResponseInfo demoPost(
      @RequestHeader("CustomHeaderName") String header, @RequestBody BaseRequestInfo request) {
    return BaseResponseInfo.builder()
        .header(header)
        .name(request.getName())
        .age(request.getAge())
        .build();
  }
}
