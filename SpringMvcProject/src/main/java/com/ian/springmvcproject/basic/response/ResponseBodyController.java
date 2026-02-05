package com.ian.springmvcproject.basic.response;

import com.ian.springmvcproject.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * 스프링 부트 기본 MessageConverter 동작 순서
 * 1. ByteArrayHttpMessageConverter -> 읽기: byte[], 쓰기: application/octet-stream
 * 2. StringHttpMessageConverter -> 읽기: String, 쓰기: text/plain
 * 3. MappingJackson2HttpMessageConverter -> 읽기: json, 쓰기: application/json
 * ...
 * <p>
 * HTTP 요청 데이터 읽기
 * 1. 요청이 들어오면 컨트롤러에서 @RequestBody, HttpEntity(RequestEntity) 사용
 * 2. 메시지 컨버터가 메시지을 읽을 수 있는지 확인 (canRead() 호출)
 *     - 대상 클래스 타입을 지원하는지 확인
 *     - HTTP 요청의 Content-Type 미디어 타입을 지원하는지 확인
 * 3. canRead() 조건을 만족하면 read() 메서드를 호출하여 객체 생성 및 반환
 * <p>
 * HTTP 응답 데이터 생성
 * 1. 컨트롤러에서 @ResponseBody, HttpEntity(ResponseEntity)로 값이 변환됨
 * 2. 메시지 컨버터가 메시지를 쓸 수 있는지 확인 (canWrite() 호출)
 *     - 대상 클래스 타입을 지원하는지 확인
 *     HTTP 요청의 Accept 미디어 타입을 지원하는지 확인
 * 3. canWrite() 조건을 만족하면 write() 메서드를 호출하여 HTTP 응답 메시지 바디에 데이터를 생성
 */
@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyStringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("OK");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<?> responseBodyStringV2() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/response-body-string-v3")
    @ResponseBody
    public String responseBodyStringV3() {
        return "OK";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("hello");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @GetMapping("/response-body-json-v2")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("hello");
        helloData.setAge(20);

        return helloData;
    }
}
