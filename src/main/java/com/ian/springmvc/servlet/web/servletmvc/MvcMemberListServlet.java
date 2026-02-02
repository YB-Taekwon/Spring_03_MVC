package com.ian.springmvc.servlet.web.servletmvc;

import com.ian.springmvc.servlet.domain.member.Member;
import com.ian.springmvc.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        // Model에 데이터 보관
        request.setAttribute("members", members);

        String viewPath = "/WEB-INF/views/members.jsp";

        request.getRequestDispatcher(viewPath)
                .forward(request, response);
    }
}
