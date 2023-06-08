//package com.example.iss_vanzari_versiunea2.model;
//
//import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "order")
//public class Order {
//    @Column(name = "products")
//    private List<Product> products;
//    @Column(name = "client")
//    private Client client;
//    @Column(name = "totalPrice")
//    private float totalPrice;
//
//    public Order(List<Product> products, Client client, float totalPrice) {
//        this.products = products;
//        this.client = client;
//        this.totalPrice = totalPrice;
//    }
//
//    public Order() {
//
//    }
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
//
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public float getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(float totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "products=" + products +
//                ", client=" + client +
//                ", totalPrice=" + totalPrice +
//                '}';
//    }
//}
