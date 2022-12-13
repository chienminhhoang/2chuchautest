package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
    T save(T t);

    void delete(Long id);

    List<T> getAll();

    T update(T t);

    Optional<T> findById(Long id);
    Optional<T> findByName(String Name);

    List<T> findAll();

}
