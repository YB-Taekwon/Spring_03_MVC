package com.ian.springmvc.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        /**
         * 리다이렉트: 클라이언트에 응답이 나갔다가 클라이언트에서 리다이렉트 경로로 재요청을 보냄 -> 클라이언트가 인지할 수 있고, url 경로도 변경됨
         * 포워드: 서버 내부에서 일어나는 호출 -> 클라이언트가 인지하지 못하고, url도 유지됨
         */
        // 다른 서블릿이나 JSP로 이동할 수 있는 기능으로 서버 내부에서 다시 호출이 발생 -> 제어권을 위임 (※ 리다이렉트가 아님)
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
