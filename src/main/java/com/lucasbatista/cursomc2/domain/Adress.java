package com.lucasbatista.cursomc2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Adress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String streetName;
    private String number;
    private String complement;
    private String district;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


    public Adress(){
    }

    public Adress(Integer id, String streetName, String number, String complement, String district, String zipCode, Client client, City city) {
        this.id = id;
        this.streetName = streetName;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zipCode = zipCode;
        this.client = client;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Client getClients() {
        return client;
    }

    public void setClients(Client client) {
        this.client = client;
    }
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return Objects.equals(id, adress.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
