package com.example.week8.util;

public interface Mapper<F, T> {
    T map(F from);

    F reverse(T to);
}