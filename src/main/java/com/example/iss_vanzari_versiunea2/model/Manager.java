package com.example.iss_vanzari_versiunea2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager extends Employee {

    @Column(name = "department")
    private String department;


    public Manager(String firstName, String lastName, String phoneNumber, String emailAddress, String username, String password, String departament) {
        super(firstName, lastName, phoneNumber, emailAddress, username, password);
        this.department = departament;
    }

    public Manager() {

    }

    public String getDepartament() {
        return department;
    }

    public void setDepartament(String departament) {
        this.department = departament;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "departament='" + department + '\'' +
                '}';
    }
}
