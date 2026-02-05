package com.ian.springmvcproject.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyStringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);

        response.getWriter().write("OK");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer writer) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);

        writer.write("OK");
    }

    /**
     * HttpEntity: 메시지 바디 정보를 직접 조회
     * 응답에도 사용 가능
     * - 메시지 바디 정보 직접 반환
     * - 헤더 정보 포함 가능
     * - view 조회 X
     */
    @PostMapping("/request-body-string-v3")
    public HttpEntity<?> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
        String messageBody = httpEntity.getBody();
        log.info("messageBody={}", messageBody);

        return new HttpEntity<>(HttpStatus.OK);
    }

    /**
     * RequestBody: HTTP 메시지 바디 정보를 편리하게 조회할 수 있음
     */
    @PostMapping("/request-body-string-v4")
    @ResponseBody
    public String requestBodyStringV3(@RequestBody String messageBody) throws IOException {
        log.info("messageBody={}", messageBody);

        return "OK";
    }
}
