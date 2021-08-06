package com.jpa.demo.board.repository;

import com.jpa.demo.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * com.jpa.board.repository
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
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
