package com.ian.springmvc.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 빈 이름: /springmvc/old-controller
 * 핸들러 매핑: 핸들러 매핑에서 해당 컨트롤러를 찾을 수 있어야 함
 * -> 스프링 빈의 이름으로 핸들러를 찾을 수 있는 핸들러 매핑이 필요 (BeanNameUrlHandlerMapping)
 * 핸들러 어댑터: 핸들러 매핑을 통해 찾은 핸들러를 실행할 수 있는 핸들러 어댑터가 필요
 * -> Controller 인터페이스를 실행할 수 있는 핸들러 어댑터를 찾고 실행해야 함 (SimpleControllerHandlerAdapter)
 */
@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public @Nullable ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        return new ModelAndView("new-form");
    }

    /**
     * 핸들러 매핑 순서
     * 1. RequestMappingHandlerMapping: 애너테이션 기반의 컨트롤러인 @RequestMapping에서 사용
     * 2. BeanNameUrlHandlerMapping: 스프링 빈의 이름으로 핸들러 탐색 v
     * <p>
     * 핸들러 어댑터 순서
     * 1. RequestMappingHandlerAdapter: 애너테이션 기반의 컨트롤러인 @RequestMapping에서 사용
     * 2. HttpRequestHandlerAdapter: HttpRequestHandler 처리
     * 3. SimpleControllerHandlerAdapter: Controller 인터페이스 처리 v
     */
}
