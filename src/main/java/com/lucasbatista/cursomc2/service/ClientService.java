package com.lucasbatista.cursomc2.service;

import com.lucasbatista.cursomc2.domain.Client;
import com.lucasbatista.cursomc2.repository.ClientRepository;
import com.lucasbatista.cursomc2.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public Client find(Integer id){
        Optional<Client> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Client.class.getName()));
    }
}
