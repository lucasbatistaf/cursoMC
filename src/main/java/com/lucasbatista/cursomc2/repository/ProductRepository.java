package com.lucasbatista.cursomc2.repository;

import com.lucasbatista.cursomc2.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
