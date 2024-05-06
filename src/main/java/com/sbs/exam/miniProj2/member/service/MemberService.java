package com.sbs.exam.miniProj2.member.service;

import com.sbs.exam.miniProj2.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
        memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
    }
}