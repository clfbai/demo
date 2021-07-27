package com.example.my_code.lambad;

import com.example.my_code.pojo.Apple;

@FunctionalInterface
public interface Filter<T> {

    boolean appleCompare(T t);
}
