package demo.core;

import demo.core.member.Grade;
import demo.core.member.Member;
import demo.core.member.MemberService;
import demo.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        var member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + findMember);
        System.out.println("find member = " + member);
    }
}
