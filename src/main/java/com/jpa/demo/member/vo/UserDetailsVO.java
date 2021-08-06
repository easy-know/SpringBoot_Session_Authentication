package com.jpa.demo.member.vo;

import com.jpa.demo.member.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * <pre>
 * com.jpa.demo.member.vo
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
 * 2021.07.28 leejinho 최초 생성
 * </pre>
 * @since 2021.07.28
 */
@Getter
@RequiredArgsConstructor
public class UserDetailsVO implements UserDetails {

    @Delegate
    private final Member member;
    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    // 잠금 여부
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
