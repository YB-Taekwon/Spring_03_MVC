package com.ian.springmvc.servlet.basic.request;

import com.ian.springmvc.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String string = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("string = " + string);

        HelloData helloData = objectMapper.readValue(string, HelloData.class);

        System.out.println("username = " + helloData.getUsername());
        System.out.println("age = " + helloData.getAge());

        response.getWriter().write("OK");
    }
}
