package com.jpa.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 * com.jpa.board.security
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
@Getter
@AllArgsConstructor
public enum Roles {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String value;
}
