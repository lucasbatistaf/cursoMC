package com.lucasbatista.cursomc2.resources;

import com.lucasbatista.cursomc2.domain.Ordered;
import com.lucasbatista.cursomc2.services.OrderedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ordered")
public class OrderedResource {

    @Autowired
    private OrderedService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Ordered> find(@PathVariable Integer id){
        Ordered obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
