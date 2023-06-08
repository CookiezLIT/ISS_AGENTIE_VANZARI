package com.example.iss_vanzari_versiunea2.model;

public class Manager extends Employee{

    private String departament;


    public Manager(String firstName, String lastName, String phoneNumber, String emailAddress, String username, String password, String departament) {
        super(firstName, lastName, phoneNumber, emailAddress, username, password);
        this.departament = departament;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "departament='" + departament + '\'' +
                '}';
    }
}
