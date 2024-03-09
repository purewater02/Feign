package com.example.feign.feign.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class DemoFeignErrorDecoder implements ErrorDecoder {
  private final ErrorDecoder errorDecoder = new Default();

  @Override
  public Exception decode(String methodKey, Response response) {
    HttpStatus httpStatus = HttpStatus.resolve(response.status());

    // 특정 코드에 대해서는 응답을 핸들링해준다.
    assert httpStatus != null;
    if (httpStatus.equals(HttpStatus.NOT_FOUND)) {
      log.info("[DemoFeignErrorDecoder] Http Status = " + httpStatus);
      throw new RuntimeException(
          String.format("[DemoFeignErrorDecoder] Http Status is %s", httpStatus));
    }

    // 특정 코드가 아닌 경우에는 default 설정을 따른다.
    return errorDecoder.decode(methodKey, response);
  }
}
