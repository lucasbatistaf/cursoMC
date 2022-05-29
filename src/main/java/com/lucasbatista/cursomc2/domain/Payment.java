package com.lucasbatista.cursomc2.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucasbatista.cursomc2.domain.enums.PaymentState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

    @Id
    private Integer id;
    private Integer state;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "ordered_id")
    @MapsId
    private Ordered ordered;

    public Payment(){

    }
    public Payment(Integer id, PaymentState state, Ordered ordered) {
        this.id = id;
        this.state = (state == null) ? null : state.getCod();
        this.ordered = ordered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentState getState() {
        return PaymentState.toEnum(state);
    }

    public void setState(PaymentState state) {
        this.state = state.getCod();
    }

    public Ordered getOrdered() {
        return ordered;
    }

    public void setOrdered(Ordered ordered) {
        this.ordered = ordered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
