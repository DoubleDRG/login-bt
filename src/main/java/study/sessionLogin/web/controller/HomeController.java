package study.sessionLogin.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import study.sessionLogin.SessionConst;
import study.sessionLogin.config.Login;
import study.sessionLogin.domain.Member;

@RequiredArgsConstructor
@Controller
public class HomeController
{
    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model)
    {
        HttpSession session = request.getSession(false);

        if (session == null)
        {
            return "home";
        }

        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        if (loginMember == null)
        {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";

    }

    @GetMapping("/")
    public String homeLoginV2(@Login Member loginMember, Model model)
    {
        if (loginMember == null)
        {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
