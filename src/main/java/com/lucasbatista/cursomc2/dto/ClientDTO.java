package com.lucasbatista.cursomc2.dto;

import com.lucasbatista.cursomc2.domain.Client;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClientDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Please, insert a name")
    @Length(min = 5, max = 120, message = "Size must be 5 up to 120")
    private String name;

    @NotEmpty(message = "Please insert a email")
    @Email(message = "Invalid Email")
    private String email;

    public ClientDTO(){

    }

    public ClientDTO(Client obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
