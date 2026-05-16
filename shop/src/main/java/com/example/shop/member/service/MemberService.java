package com.example.shop.member.service;

import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;
import com.example.shop.member.entity.Member;

import java.util.List;

public interface MemberService {

    void createMember(MemberCreateRequest request);

    List<Member> getMembers();

    Member getMember(Long memberId);

    void updateMember(Long memberId, MemberUpdateRequest request);

    void deleteMember(Long memberId);
}
