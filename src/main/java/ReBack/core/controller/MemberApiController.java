package ReBack.core.controller;

import ReBack.core.data.Member;
import ReBack.core.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberApiController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostMapping("/singUp")
    public String insertUser1(@RequestBody Member member) {
        if (member.getMemberId() == "" || member.getMemberId() == null) {
            member.setMemberId("member");
        }

        Optional<Member> idCheck = memberRepository.findByMemberId(member.getMemberId());

        if (idCheck.isPresent() == true) {
//                && idCheck.isPresent() ==true ) {
            return "no";
        } else {
            String encodedPassword = passwordEncoder.encode(member.getMemberPassword());
            member.setMemberPassword(encodedPassword);
            memberRepository.save(member);
            return "ok";
        }
//
    }

    @PostMapping("/idCheck")
    public String insertUser(@RequestBody Member member) {
        System.out.println(member.getMemberId());
        String inputId = member.getMemberId();
        if (inputId == "" || inputId == null) {
            return "ng";
        }
        Optional<Member> idCheck = memberRepository.findByMemberId(inputId);
        if (idCheck.isPresent() == true) {
            return "no";
        } else {
            return "ok";
        }
    }

    @PostMapping("/login")
    public String chkUser(@RequestBody Member member) {
        System.out.println(member.getMemberId());
        String inputId = member.getMemberId();
        Optional<Member> adminchk = memberRepository.findByMemberId(inputId);
        Member adminCheck = adminchk.get();

        if (adminCheck.getMemberId().equals(inputId) &&
                passwordEncoder.matches(member.getMemberPassword(), adminCheck.getMemberPassword())) {
            // 입력한 비밀번호, 디비 비밀번호 비교
            return "ok";
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return "no";
        }
    }




}
