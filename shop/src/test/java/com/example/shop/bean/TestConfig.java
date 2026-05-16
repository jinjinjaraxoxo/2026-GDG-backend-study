package com.example.shop.bean;

import com.example.shop.member.repository.MemberRepository;
import com.example.shop.member.repository.MemoryMemberRepository;
import com.example.shop.member.service.MemberService;
import com.example.shop.member.service.MemberServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
}
