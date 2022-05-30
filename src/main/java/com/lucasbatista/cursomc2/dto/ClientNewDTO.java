package com.lucasbatista.cursomc2.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClientNewDTO implements Serializable {

    @NotEmpty(message = "Please, insert a name")
    @Length(min = 5, max = 120, message = "Size must be 5 up to 120")
    private String name;

    @NotEmpty(message = "Please insert a email")
    @Email(message = "Invalid Email")
    private String email;

    @NotEmpty(message = "Please insert a CPF or CNPJ")
    private String cpfOrCnpj;
    private Integer typeClient;

    @NotEmpty(message = "Please insert a street name")
    private String streetName;

    @NotEmpty(message = "Please insert a street number")
    private String number;
    private String complement;
    private String district;

    @NotEmpty(message = "Please insert a zipcode")
    private String zipCode;


    @NotEmpty(message = "Please insert a telephone number")
    private String telephoneNumber1;
    private String telephoneNumber2;
    private String telephoneNumber3;

    private Integer cityId;

    public ClientNewDTO(){

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

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public Integer getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(Integer typeClient) {
        this.typeClient = typeClient;
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

    public String getTelephoneNumber1() {
        return telephoneNumber1;
    }

    public void setTelephoneNumber1(String telephoneNumber1) {
        this.telephoneNumber1 = telephoneNumber1;
    }

    public String getTelephoneNumber2() {
        return telephoneNumber2;
    }

    public void setTelephoneNumber2(String telephoneNumber2) {
        this.telephoneNumber2 = telephoneNumber2;
    }

    public String getTelephoneNumber3() {
        return telephoneNumber3;
    }

    public void setTelephoneNumber3(String telephoneNumber3) {
        this.telephoneNumber3 = telephoneNumber3;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
