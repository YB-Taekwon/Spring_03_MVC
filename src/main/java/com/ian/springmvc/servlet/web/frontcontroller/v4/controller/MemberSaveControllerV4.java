package com.ian.springmvc.servlet.web.frontcontroller.v4.controller;

import com.ian.springmvc.servlet.domain.member.Member;
import com.ian.springmvc.servlet.domain.member.MemberRepository;
import com.ian.springmvc.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> params, Map<String, Object> model) {
        String username = params.get("username");
        int age = Integer.parseInt(params.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);

        return "save";
    }
}
