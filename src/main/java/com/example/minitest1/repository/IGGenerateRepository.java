package com.example.minitest1.repository;

import java.util.List;

public interface IGGenerateRepository<T> {

    List<T> findAll();
    T findById(int id);
    boolean insert(T t);
    void remove(int id);

    boolean update(T t);

}