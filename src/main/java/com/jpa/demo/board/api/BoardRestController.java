package com.jpa.demo.board.api;

import com.jpa.demo.board.dto.BoardDto;
import com.jpa.demo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * com.jpa.board.controller
 *
 * Description :
 * </pre>
 *
 * @author leejinho
 * @version 1.0
 * <pre>
 * == 개정이력(Modification Information) ==
 *
 * 수정일     수정자   수정내용
 * ---------- -------- -------------------
 * 2021.07.15 leejinho 최초 생성
 * </pre>
 * @since 2021.07.15
 */
@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping(value = {"/", "/{id}"})
    public ResponseEntity<BoardDto> list(BoardDto boardDto) {
//        return ResponseEntity.ok();
        return null;
    }
}
