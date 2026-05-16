package com.example.shop.member.repository;

import com.example.shop.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findAll();

    Optional<Member> findByLoginId(String loginId);

    void delete(Member member);
}
