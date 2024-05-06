package com.sbs.exam.miniProj2.member.controller;

import com.sbs.exam.miniProj2.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrMemberController {
    private MemberService memberService;

    public UsrMemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/usr/member/doJoin")
    @ResponseBody
    public String doJoin(String loginId, String loginPw, String name, String nickname,
                         String cellphoneNo, String email) {
        memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
        return "성공";
    }

}