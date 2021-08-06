package com.jpa.demo.mapper;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
public interface GenericMapper <D, E> {
    D toDto(E e);
    E toEntity(D d);
}
