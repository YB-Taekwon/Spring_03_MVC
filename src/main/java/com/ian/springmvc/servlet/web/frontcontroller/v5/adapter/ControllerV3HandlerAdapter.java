package com.ian.springmvc.servlet.web.frontcontroller.v5.adapter;

import com.ian.springmvc.servlet.web.frontcontroller.ModelView;
import com.ian.springmvc.servlet.web.frontcontroller.v3.ControllerV3;
import com.ian.springmvc.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controllerV3 = (ControllerV3) handler;

        Map<String, String> params = createParams(request);
        ModelView modelView = controllerV3.process(params);

        return modelView;
    }

    private Map<String, String> createParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> params.put(paramName, request.getParameter(paramName)));

        return params;
    }
}
