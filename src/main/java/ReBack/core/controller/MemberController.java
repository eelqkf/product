package ReBack.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/member")
    public String index() {
        return "member";
    }

    @GetMapping("/member/login")
    public String login() {
        return "signIn";

    }
    @GetMapping("/member/signupType")
    public String memberSignupType() {

        return "signupType";
    }
    @GetMapping("/member/generalSignup")
    public String generalSignup() {

        return "memberSignUp";
    }


}
