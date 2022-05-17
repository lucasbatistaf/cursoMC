package com.lucasbatista.cursomc2.service;

import com.lucasbatista.cursomc2.domain.Category;
import com.lucasbatista.cursomc2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category find(Integer id){
        Optional<Category> obj = repo.findById(id);
        return obj.orElse(null);
    }
}