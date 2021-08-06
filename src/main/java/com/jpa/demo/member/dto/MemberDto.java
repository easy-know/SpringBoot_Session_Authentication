package com.jpa.demo.member.dto;

import com.jpa.demo.common.Regex;
import com.jpa.demo.enums.Roles;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * <pre>
 * com.jpa.demo.board.dto
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
 * 2021.07.26 leejinho 최초 생성
 * </pre>
 * @since 2021.07.26
 */
@Getter
@Setter
public class MemberDto {
    private Long id;

    @NotNull(message = "이름은 Null 일 수 없습니다/")
    @Size(min = 1, max = 10, message = "이름은 1 ~ 10자 이여야 합니다!")
    private String username;

    @NotNull(message = "이메일은 Null 일 수 없습니다.")
    @Email
    private String email;

    @NotNull(message = "비밀번호는 Null 일 수 없습니다.")
    @Pattern(regexp = Regex.passwordPattern)
    private String password;

    @NotNull(message = "비밀번호는 Null 일 수 없습니다.")
    @Pattern(regexp = Regex.passwordPattern)
    private String passwordCheck;

    private Roles authority;
}
