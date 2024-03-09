package com.example.feign.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {

  @Override
  public void apply(RequestTemplate requestTemplate) {
    // get 요청일 경우
    if (Objects.equals(requestTemplate.method(), HttpMethod.GET.name())) {
      System.out.println("[GET] [DemoFeignInterceptor] queries : " + requestTemplate.queries());
    }

    // post 요청일 경우
    String encodedBody =
        StringUtils.toEncodedString(requestTemplate.body(), StandardCharsets.UTF_8);
    System.out.println("[POST] [DemoFeignInterceptor] requestBody : " + encodedBody);

    // 받은 바디 변경 등 추가 로직을 정의할 수 있다.
    String convertedRequestBody = encodedBody;
    requestTemplate.body(convertedRequestBody);
  }
}
