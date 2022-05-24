package com.lucasbatista.cursomc2.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasbatista.cursomc2.domain.enums.PaymentState;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentMoney extends Payment{


    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date paymentDue;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date paymentDate;

    public PaymentMoney(){

    }

    public PaymentMoney(Integer id, PaymentState state, Ordered ordered, Date paymentDue, Date paymentDate) {
        super(id, state, ordered);
        this.paymentDue = paymentDue;
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(Date paymentDue) {
        this.paymentDue = paymentDue;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

}
