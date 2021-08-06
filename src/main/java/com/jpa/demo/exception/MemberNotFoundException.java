package com.jpa.demo.exception;

/**
 * <pre>
 * com.jpa.demo.exception
 *
 * Description :
 * </pre>
 *
 * @author leejinho
 * @version 1.0
 * @since 2021.07.27
 */
public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String email) {
        super(email + "- NotFoundException");
    }
}
