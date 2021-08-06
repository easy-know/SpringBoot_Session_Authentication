package com.jpa.demo.common;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * <pre>
 * com.jpa.board.entity
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
@MappedSuperclass
@Setter
@Getter
@DynamicInsert
public class BaseEntity {
    @Column(name="CREATE_ID", updatable = false)
    private String 	createId;

    @CreatedDate
    @Column(name="CREATE_DATE_TIME", updatable = false)
    private LocalDateTime createDateTime;

    @Column(name="MODIFY_ID")
    private String 	modifyId;

    @LastModifiedDate
    @Column(name="MODIFY_DATE_TIME")
    private LocalDateTime modifyDateTime;
}