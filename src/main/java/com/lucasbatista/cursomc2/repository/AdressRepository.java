package com.lucasbatista.cursomc2.repository;

import com.lucasbatista.cursomc2.domain.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
