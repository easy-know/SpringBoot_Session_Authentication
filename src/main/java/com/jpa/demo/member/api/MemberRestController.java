package com.jpa.demo.member.api;

import com.jpa.demo.member.dto.MemberDto;
import com.jpa.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <pre>
 * com.jpa.demo.member.api
 *
 * Description :
 * </pre>
 *
 * @author leejinho
 * @version 1.0
 *
 */
@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberRestController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDto> saveMember(@RequestBody @Valid MemberDto memberDto) {

        if (memberService.checkEmailDuplicate(memberDto.getEmail())) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(memberService.saveMember(memberDto));
    }
}
