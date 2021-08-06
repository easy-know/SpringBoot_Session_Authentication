package com.jpa.demo.member.service;

import com.jpa.demo.mapper.MemberMapper;
import com.jpa.demo.member.dto.MemberDto;
import com.jpa.demo.exception.MemberNotFoundException;
import com.jpa.demo.member.repository.MemberRepository;
import com.jpa.demo.member.vo.UserDetailsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * <pre>
 * com.jpa.demo.member.service
 *
 * Description :
 * </pre>
 *
 * @author leejinho
 * @version 1.0
 *
 * <pre>
 * == 개정이력(Modification Information) ==
 *
 * 수정일     수정자   수정내용
 * ---------- -------- -------------------
 * 2021.07.23 leejinho 최초 생성
 * </pre>
 * @since 2021.07.23
 */
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService{
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberDto saveMember(MemberDto memberDto) {

        memberDto.setPassword(new BCryptPasswordEncoder().encode(memberDto.getPassword()));
//        Member member = Member.builder()
//                .email(memberDto.getEmail())
//                .password(new BCryptPasswordEncoder().encode(memberDto.getPassword()))
//                .username(memberDto.getUsername())
//                .role(Roles.USER)
//                .build();

        return memberMapper.toDto(memberRepository.save(memberMapper.toEntity(memberDto)));
    }

    public boolean checkEmailDuplicate(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findByEmail(email).map(member -> new UserDetailsVO(member, Collections.singleton(new
                SimpleGrantedAuthority(member.getRole().getValue())))).orElseThrow(() -> new MemberNotFoundException(email));
    }
}
