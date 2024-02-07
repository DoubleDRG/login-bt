package study.sessionLogin.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.sessionLogin.domain.Member;
import study.sessionLogin.domain.MemberRepository;

@Component
@RequiredArgsConstructor
public class TestDataInit
{
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init()
    {
        Member member = new Member();
        member.setLoginId("dyl0115");
        member.setPassword("endyd132!!");
        member.setName("david");
        memberRepository.save(member);
    }
}
