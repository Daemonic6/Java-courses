package ru.java;
public interface ICollection<T> {
    boolean contains(T s);
    int getSize();
    void add(T value);
    int remove(int index);
    }

