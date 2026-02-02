package com.ian.springmvc.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clear();
    }

    @Test
    void save() {
        // given
        Member member = new Member("username", 20);

        // when
        Member saveMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("username1", 20);
        Member member2 = new Member("username2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members).hasSize(2);
        assertThat(members).contains(member1, member2);
    }
}