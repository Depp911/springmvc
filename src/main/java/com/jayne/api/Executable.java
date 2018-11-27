package com.jayne.api;

/**
 * 为了事务调用而存在的接口
 */
public interface Executable<V> {

    V exec();

}