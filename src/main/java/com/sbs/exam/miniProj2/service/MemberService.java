package com.sbs.exam.miniProj2.service;

import com.sbs.exam.miniProj2.repository.MemberRepository;
import com.sbs.exam.miniProj2.util.Ut;
import com.sbs.exam.miniProj2.vo.Member;
import com.sbs.exam.miniProj2.vo.ResultData;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public ResultData join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {

        // 로그인 아이디 중복 체크
        Member oldMember = getMemberByLoginId(loginId);

        if( oldMember != null ) {
            return ResultData.from("F-7", Ut.f("해당 로그인아이디(%s)는 이미 사용중입니다.",loginId));
        }
//
//        // 이름 + 이메일 중복체크
        Member oldNameAndEmail = getMemberByNameAndEmail(name, email);

        if( oldNameAndEmail != null ) {
            return ResultData.from("F-8", Ut.f("해당 이름과(%s)는 이메일은 이미 사용중입니다.",loginId));
        }

        memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
        int id = memberRepository.getLastInsertId();

        return ResultData.from("S-1","회원 가입이 완료되었습니다",id);
    }

    private Member getMemberByNameAndEmail(String name, String email) {
        return memberRepository.getMemberByNameAndEmail(name, email);
    }

    private Member getMemberByLoginId(String loginId) {
        return memberRepository.getMemberByLoginId(loginId);
    }

    public Member getMemberById(int id) {
        return memberRepository.getMemberById(id);
    }
}