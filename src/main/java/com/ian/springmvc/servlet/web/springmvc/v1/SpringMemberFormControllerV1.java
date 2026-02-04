package com.ian.springmvc.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller
 * - 스프링이 빈을 자동으로 등록 -> ComponentScan 대상
 * - SpringMVC에서 애너테이션 기반 컨트롤러로 인식
 */
@Controller
//@Component
//@RequestMapping
public class SpringMemberFormControllerV1 {

    // 요청 정보를 매핑 -> 해당 URL이 호출되면 메서드가 호출됨
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
