package com.lucasbatista.cursomc2.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ProductOrdered implements Serializable {

    @EmbeddedId
    private ProductOrderedPK id = new ProductOrderedPK();

    private Double discount;
    private Integer quantity;
    private Double price;

    public ProductOrdered(){

    }

    public ProductOrdered(Ordered ordered, Product product, Double discount, Integer quantity, Double price) {
        id.setOrdered(ordered);
        id.setProduct(product);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    public Ordered getOrdered(){
        return id.getOrdered();
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public ProductOrderedPK getId() {
        return id;
    }

    public void setId(ProductOrderedPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrdered)) return false;
        ProductOrdered that = (ProductOrdered) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
