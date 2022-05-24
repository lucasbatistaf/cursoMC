package com.lucasbatista.cursomc2.domain;

import com.lucasbatista.cursomc2.domain.enums.PaymentState;

import javax.persistence.Entity;

@Entity
public class PaymentCreditCard extends Payment{

    private Integer installmentNumber;

    public PaymentCreditCard(){

    }

    public PaymentCreditCard(Integer id, PaymentState state, Ordered ordered, Integer installmentNumber) {
        super(id, state, ordered);
        this.installmentNumber = installmentNumber;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }
}
