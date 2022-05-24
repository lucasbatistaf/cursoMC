package com.lucasbatista.cursomc2.service;

import com.lucasbatista.cursomc2.domain.Ordered;
import com.lucasbatista.cursomc2.repository.OrderedRepository;
import com.lucasbatista.cursomc2.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderedService {

    @Autowired
    private OrderedRepository repo;

    public Ordered find(Integer id){
        Optional<Ordered> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Ordered.class.getName()));
    }
}
