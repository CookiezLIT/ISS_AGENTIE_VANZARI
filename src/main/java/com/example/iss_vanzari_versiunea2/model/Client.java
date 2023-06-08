package com.example.iss_vanzari_versiunea2.model;

public class Client extends Person {
    private String company;
    private String deliveryAddress;

    public Client(String firstName, String lastName, String phoneNumber, String emailAddress, String company, String deliveryAddress) {
        super(firstName, lastName, phoneNumber, emailAddress);
        this.company = company;
        this.deliveryAddress = deliveryAddress;
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
