package com.jpa.demo.config.security;

import com.jpa.demo.member.service.MemberService;
import com.jpa.demo.member.vo.UserDetailsVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <pre>
 * com.jpa.demo.config.security
 *
 * Description :
 * </pre>
 *
 * @author leejinho
 * @version 1.0

 * @since 2021.07.27
 */
@RequiredArgsConstructor
@Log4j2
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final MemberService memberService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String email = token.getName();
        String password = (String) token.getCredentials();
        UserDetailsVO userDetailsVO = (UserDetailsVO) memberService.loadUserByUsername(email);
        if (!passwordEncoder.matches(password, userDetailsVO.getPassword())) {
            throw new BadCredentialsException(userDetailsVO.getUsername() + " - Invalid Password");
        }

        return new UsernamePasswordAuthenticationToken(userDetailsVO, password, userDetailsVO.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
