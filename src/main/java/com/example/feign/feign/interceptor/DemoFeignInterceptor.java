package com.example.feign.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {

  @Override
  public void apply(RequestTemplate requestTemplate) {
    // get 요청일 경우
    if (Objects.equals(requestTemplate.method(), HttpMethod.GET.name())) {
      log.info("[GET] [DemoFeignInterceptor] queries : " + requestTemplate.queries());
    }

    // post 요청일 경우
    String encodedBody =
        StringUtils.toEncodedString(requestTemplate.body(), StandardCharsets.UTF_8);
    log.info("[POST] [DemoFeignInterceptor] requestBody : " + encodedBody);

    // 받은 바디 변경 등 추가 로직을 정의할 수 있다.
    String convertedRequestBody = encodedBody;
    requestTemplate.body(convertedRequestBody);
  }
}
