package com.alice.syncly.web;

import com.alice.syncly.domain.Member;
import com.alice.syncly.service.MemberService;
import com.alice.syncly.web.dto.MemberCreateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    private final MemberService memberService;

    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new MemberCreateRequest());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(MemberCreateRequest request, Model model) {
        // 기본 권한 ROLE_USER
        Member member = memberService.createMember(
                request.getEmail(),
                request.getPassword(),
                request.getName(),
                request.getRole() != null ? request.getRole() : "ROLE_USER"
        );
        model.addAttribute("signupSuccess", true);
        return "redirect:/login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

