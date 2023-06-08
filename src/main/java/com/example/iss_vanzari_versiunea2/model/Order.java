package com.example.iss_vanzari_versiunea2.model;

import java.util.List;

public class Order {
    private List<Product> products;
    private Client client;
    private float totalPrice;

    public Order(List<Product> products, Client client, float totalPrice) {
        this.products = products;
        this.client = client;
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", client=" + client +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
