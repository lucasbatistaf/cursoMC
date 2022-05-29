package com.lucasbatista.cursomc2.service;

import com.lucasbatista.cursomc2.domain.Address;
import com.lucasbatista.cursomc2.domain.City;
import com.lucasbatista.cursomc2.domain.Client;
import com.lucasbatista.cursomc2.domain.enums.TypeClient;
import com.lucasbatista.cursomc2.dto.ClientDTO;
import com.lucasbatista.cursomc2.dto.ClientNewDTO;
import com.lucasbatista.cursomc2.repository.ClientRepository;
import com.lucasbatista.cursomc2.service.exceptions.DataIntegrityException;
import com.lucasbatista.cursomc2.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional
    public Client insert(Client obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Client update(Client obj){
        Client newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try{
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Not possible to delete Client " + id + ", because there's a known order");
        }
    }
    public List<Client> findAll(){
        return repo.findAll();
    }

    public Page<Client> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Client fromDTO(ClientDTO objDTO){
        return new Client(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), null, null);
    }

    public Client fromDTO(ClientNewDTO objDTO){
        Client client = new Client(null, objDTO.getName(), objDTO.getEmail(), objDTO.getCpfOrCnpj(), TypeClient.toEnum(objDTO.getTypeClient()));
        City city = new City(objDTO.getCityId(), null, null);
        Address address = new Address(null, objDTO.getStreetName(), objDTO.getNumber(), objDTO.getComplement(), objDTO.getDistrict(), objDTO.getZipCode(), client, city);
        client.getAddresses().add(address);
        client.getTelephoneNumber().add(objDTO.getTelephoneNumber1());
        if(objDTO.getTelephoneNumber2() != null){
            client.getTelephoneNumber().add(objDTO.getTelephoneNumber2());
        }
        if(objDTO.getTelephoneNumber2() != null) {
            client.getTelephoneNumber().add(objDTO.getTelephoneNumber3());
        }

        return client;
    }

    private void updateData(Client newObj, Client obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
