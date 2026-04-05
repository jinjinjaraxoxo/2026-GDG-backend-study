package com.example.shop.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateRequest {

    private String loginId;
    private String password;
    private String phoneNumber;
    private String address;
}