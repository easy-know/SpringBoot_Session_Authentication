package com.jpa.demo.common;

/**
 * Description : 정규식
 *
 * @author leejinho
 * @version 1.0
 */
public class Regex {
    public static final String passwordPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$"; // 영문, 숫자, 특수문자
}
