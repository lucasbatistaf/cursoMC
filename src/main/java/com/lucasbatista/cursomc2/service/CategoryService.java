package com.lucasbatista.cursomc2.service;

import com.lucasbatista.cursomc2.domain.Category;
import com.lucasbatista.cursomc2.dto.CategoryDTO;
import com.lucasbatista.cursomc2.repository.CategoryRepository;
import com.lucasbatista.cursomc2.service.exceptions.DataIntegrityException;
import com.lucasbatista.cursomc2.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category find(Integer id){
        Optional<Category> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Category.class.getName()));
    }

    public Category insert(Category obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Category update(Category obj){
        Category newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try{
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Not possible to delete Category " + id + ", because it's linked to a Product");
        }
    }
    public List<Category> findAll(){
        return repo.findAll();
    }

    public Page<Category> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public  Category fromDTO(CategoryDTO objDTO){
        return new Category(objDTO.getId(), objDTO.getName());
    }

    private void updateData(Category newObj, Category obj){
        newObj.setName(obj.getName());
    }
}
