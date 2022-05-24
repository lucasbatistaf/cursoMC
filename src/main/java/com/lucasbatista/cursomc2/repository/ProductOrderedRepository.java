package com.lucasbatista.cursomc2.repository;

import com.lucasbatista.cursomc2.domain.ProductOrdered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderedRepository extends JpaRepository<ProductOrdered, Integer> {
}
