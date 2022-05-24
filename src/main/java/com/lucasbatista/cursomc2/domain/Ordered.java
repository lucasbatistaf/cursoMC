package com.lucasbatista.cursomc2.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Ordered implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date orderedTime;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordered")
    private Payment payment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "ordered_address_id")
    private Address orderedAddress;

    @OneToMany(mappedBy = "id.ordered")
    private Set<ProductOrdered> productOrdered = new HashSet<>();

    public Ordered(){}

    public Ordered(Integer id, Date orderedTime, Client client, Address orderedAddress) {
        this.id = id;
        this.orderedTime = orderedTime;
        this.client = client;
        this.orderedAddress = orderedAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Date orderedTime) {
        this.orderedTime = orderedTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getOrderedAddress() {
        return orderedAddress;
    }

    public void setOrderedAddress(Address orderedAddress) {
        this.orderedAddress = orderedAddress;
    }

    public Set<ProductOrdered> getProductOrdered() {
        return productOrdered;
    }

    public void setProductOrdered(Set<ProductOrdered> productOrdered) {
        this.productOrdered = productOrdered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ordered)) return false;
        Ordered ordered = (Ordered) o;
        return Objects.equals(id, ordered.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
