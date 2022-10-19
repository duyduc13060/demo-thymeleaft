package com.example.demothymeleaft.service.impl;

import com.example.demothymeleaft.model.entity.CategoryEntity;
import com.example.demothymeleaft.repository.CategoryRepository;
import com.example.demothymeleaft.service.CategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryServiceImpl implements CategoriService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity create(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public Optional<CategoryEntity> findById(Long id){
        return categoryRepository.findById(id);
    }

    @Override
    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }

}
