package com.lucasbatista.cursomc2.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductOrderedPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ordered_id")
    private Ordered ordered;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Ordered getOrdered() {
        return ordered;
    }

    public void setOrdered(Ordered ordered) {
        this.ordered = ordered;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrderedPK)) return false;
        ProductOrderedPK that = (ProductOrderedPK) o;
        return Objects.equals(ordered, that.ordered) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordered, product);
    }
}
