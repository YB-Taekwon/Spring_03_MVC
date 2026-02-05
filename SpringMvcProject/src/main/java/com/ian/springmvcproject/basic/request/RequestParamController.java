package com.ian.springmvcproject.basic.request;

import com.ian.springmvcproject.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("OK");
    }

    @RequestMapping("request-param-v2")
    @ResponseBody
    public String requestParamV2(@RequestParam("username") String username, @RequestParam("age") int age) {
        log.info("username={}, age={}", username, age);

        return "OK";
    }

    @RequestMapping("request-param-v3")
    @ResponseBody
    public String requestParamV3(@RequestParam String username, @RequestParam int age) {
        log.info("username={}, age={}", username, age);

        return "OK";
    }

    /**
     * String, int, Integer 등의 단순 타입이면 @RequestParam도 생략 가능
     * 그래도 가독성을 위해 애너테이션을 작성하는 것을 추천
     */
    @RequestMapping("request-param-v4")
    @ResponseBody
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);

        return "OK";
    }

    /**
     * required: 파라미터 필수 여부
     * -> true = 필수, false = 선택
     * required = false로 받을 경우 null이 들어올 수 있기 때문에 Wrapper 타입으로 받아야 함
     * 단, 파라미터를 아예 생략하는 것이 아닌 공란을 보낼 경우 해당 값을 공란으로 인식하여 통과함
     */
    @RequestMapping("request-param-required")
    @ResponseBody
    public String requestParamRequired(
            @RequestParam(required = true) String username, @RequestParam(required = false) Integer age
    ) {
        log.info("username={}, age={}", username, age);

        return "OK";
    }

    /**
     * 데이터가 공란으로 들어와도 default 값이 적용됨
     */
    @RequestMapping("request-param-default")
    @ResponseBody
    public String requestParamDefault(
            @RequestParam(defaultValue = "hello") String username, @RequestParam(defaultValue = "20") int age
    ) {
        log.info("username={}, age={}", username, age);

        return "OK";
    }

    /**
     * 파라미터의 값이 여러 개일 경우 하나의 키에 여러 값을 담을 수 있는 MultiValueMap 사용
     */
    @RequestMapping("request-param-map")
    @ResponseBody
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "OK";
    }

    @RequestMapping("/model-attribute-v1")
    @ResponseBody
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("helloData={}", helloData);

        return "OK";
    }

    /**
     * 요청 데이터의 타입이 객체일 경우 ModelAttribute 생략 가능
     */
    @RequestMapping("/model-attribute-v2")
    @ResponseBody
    public String modelAttributeV2(HelloData helloData) {
        log.info("helloData={}", helloData);

        return "OK";
    }
}
