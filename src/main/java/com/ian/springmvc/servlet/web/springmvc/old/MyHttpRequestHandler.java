package com.ian.springmvc.servlet.web.springmvc.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;

@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }

    /**
     * 핸들러 매핑 순서
     * 1. RequestMappingHandlerMapping: 애너테이션 기반의 컨트롤러인 @RequestMapping에서 사용
     * 2. BeanNameUrlHandlerMapping: 스프링 빈의 이름으로 핸들러 탐색 v
     * <p>
     * 핸들러 어댑터 순서
     * 1. RequestMappingHandlerAdapter: 애너테이션 기반의 컨트롤러인 @RequestMapping에서 사용
     * 2. HttpRequestHandlerAdapter: HttpRequestHandler 처리 v
     * 3. SimpleControllerHandlerAdapter: Controller 인터페이스 처리
     */
}
