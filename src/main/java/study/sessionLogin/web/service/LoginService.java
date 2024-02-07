package study.sessionLogin.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.sessionLogin.domain.Member;
import study.sessionLogin.domain.MemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService
{
    private final MemberRepository memberRepository;

    public Member login(String loginId, String password)
    {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
