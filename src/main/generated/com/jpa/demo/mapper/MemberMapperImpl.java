package com.jpa.demo.mapper;

import com.jpa.demo.member.dto.MemberDto;
import com.jpa.demo.member.entity.Member;
import com.jpa.demo.member.entity.Member.MemberBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-05T16:49:18+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_275 (ojdkbuild)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDto toDto(Member e) {
        if ( e == null ) {
            return null;
        }

        MemberDto memberDto = new MemberDto();

        memberDto.setId( e.getId() );
        memberDto.setUsername( e.getUsername() );
        memberDto.setEmail( e.getEmail() );
        memberDto.setPassword( e.getPassword() );

        return memberDto;
    }

    @Override
    public Member toEntity(MemberDto d) {
        if ( d == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.id( d.getId() );
        member.username( d.getUsername() );
        member.email( d.getEmail() );
        member.password( d.getPassword() );

        return member.build();
    }
}
