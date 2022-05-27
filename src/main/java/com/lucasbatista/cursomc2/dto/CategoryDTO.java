package com.lucasbatista.cursomc2.dto;

import com.lucasbatista.cursomc2.domain.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Field cannot be empty")
    @Length(min = 5, max = 80, message = "Minimum 5 and maximum of 80 characters")
    private String name;

    public CategoryDTO(){

    }
    public CategoryDTO(Category obj){
        id = obj.getId();
        name = obj.getName();
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
