package com.meepshadow.mysticsbiomes.common.util.library;

@FunctionalInterface
public interface Modifier<T> {
    public T modify(T toModify);
}
