package com.lucasbatista.cursomc2.repository;

import com.lucasbatista.cursomc2.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
