package com.example.FinalProject.service;

import java.util.List;

public interface BaseService<T> {
    T save(T t);

    T getById(Long id);

    List<T> getAll();

    T deleteById(Long id);
}
