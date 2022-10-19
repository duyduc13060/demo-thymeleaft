package com.example.demothymeleaft.service;

import com.example.demothymeleaft.model.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoriService {
    CategoryEntity create(CategoryEntity categoryEntity);

    Optional<CategoryEntity> findById(Long id);

    List<CategoryEntity> findAll();
}
