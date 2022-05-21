package com.lucasbatista.cursomc2.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lucasbatista.cursomc2.domain.enums.TypeClient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpfOuCnpj;
    private Integer typeClient;

    @JsonManagedReference
    @OneToMany(mappedBy = "clients")
    private List<Adress> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEPHONE_NUMBER")
    private Set<String> telephoneNumber = new HashSet<>();

    public Client(){
    }

    public Client(Integer id, String name, String email, String cpfOuCnpj, TypeClient typeClient) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.typeClient = typeClient.getCod();
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

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TypeClient getTypeClient() {
        return TypeClient.toEnum(typeClient);
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient.getCod();
    }

    public List<Adress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Adress> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephones(Set<String> telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
