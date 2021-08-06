package com.jpa.demo.mapper;

import com.jpa.demo.member.dto.MemberDto;
import com.jpa.demo.member.entity.Member;
import org.mapstruct.Mapper;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface MemberMapper extends GenericMapper<MemberDto, Member> {
}
