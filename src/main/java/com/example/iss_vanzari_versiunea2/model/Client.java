package com.example.iss_vanzari_versiunea2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends Person {
    @Column(name = "company")
    private String company;
    @Column(name = "deliveryAddress")
    private String deliveryAddress;

    public Client(String firstName, String lastName, String phoneNumber, String emailAddress, String company, String deliveryAddress) {
        super(firstName, lastName, phoneNumber, emailAddress);
        this.company = company;
        this.deliveryAddress = deliveryAddress;
    }

    public Client() {

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "company='" + company + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }
}
