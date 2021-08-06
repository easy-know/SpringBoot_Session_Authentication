package com.jpa.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <pre>
 * com.jpa.board.controller
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
 * 2021.07.16 leejinho 최초 생성
 * </pre>
 * @since 2021.07.16
 */
@Controller
public class MainController {

    @GetMapping("/sign-up")
    public String signUpView() {
        return "sign-up";
    }

    @GetMapping("/sign-in")
    public String signInView() {
        return "sign-in";
    }
}
