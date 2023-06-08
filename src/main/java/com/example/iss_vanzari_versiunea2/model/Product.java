package com.example.iss_vanzari_versiunea2.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends Identifiable{
    @Column(name = "name")
    private String name;
    @Column(name = "countryOfOrigin")
    private String countryOfOrigin;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private float price;


    public Product(String name, String countryOfOrigin, int quantity, float price) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
