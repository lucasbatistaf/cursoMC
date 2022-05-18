package com.lucasbatista.cursomc2.repository;

import com.lucasbatista.cursomc2.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
