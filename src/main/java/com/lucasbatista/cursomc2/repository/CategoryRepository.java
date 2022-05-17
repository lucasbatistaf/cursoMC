package com.lucasbatista.cursomc2.repository;

import com.lucasbatista.cursomc2.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
