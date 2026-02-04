package com.ian.springmvc;

import com.ian.springmvc.servlet.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class SpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

    /**
     * 스프링 부트 뷰 리졸버
     * 1. BeanNameViewResolver: 빈 이름으로 뷰를 찾아서 반환
     * 2. InternalResourceViewResolver: JSP를 처리할 수 있는 뷰 반환 v
     * <p>
     * - InternalResourceViewResolver: 말 그대로 JSP와 같이 내부에서 자원이 이동하는 경우 사용
     */
    // application.properties에 작성한 ViewResolver와 동일한 동작 -> Spring Boot가 아래의 빈 등록을 대신 해줌
//    @Bean
//    ViewResolver internalResourceViewResolver() {
//        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//    }

    // 컨트롤러 빈 직접 등록 (컴포넌트 스캔 애너테이션 사용 X)
//    @Bean
//    SpringMemberFormControllerV1 springMemberFormControllerV1() {
//        return new SpringMemberFormControllerV1();
//    }
}
