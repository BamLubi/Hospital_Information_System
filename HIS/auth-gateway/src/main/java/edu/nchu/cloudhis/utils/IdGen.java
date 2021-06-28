package edu.nchu.cloudhis.utils;


@FunctionalInterface
public interface IdGen<T> {
    T genId();
}
