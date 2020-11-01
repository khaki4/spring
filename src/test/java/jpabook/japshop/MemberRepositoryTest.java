package jpabook.japshop;

import jpabook.japshop.domain.Member;
import jpabook.japshop.domain.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception {
        // given
        Member member = new Member();
//        member.setUsername("memberA");

        // when
        Long savedId = memberRepository.save(member);
        Member foundMember = memberRepository.find(savedId);

        // then
        Assertions.assertThat(foundMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(foundMember.getUsername()).isEqualTo(member.getUsername());

    }
    
}