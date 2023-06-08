package com.example.iss_vanzari_versiunea2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent extends Employee {
    @Column(name = "yearsInCompany")
    private int yearsInCompany;

    public Agent() {
        super();
    }

    public Agent(String firstName, String lastName, String phoneNumber, String emailAddress, String username, String password, int yearsInCompany) {
        super(firstName, lastName, phoneNumber, emailAddress, username, password);
        this.yearsInCompany = yearsInCompany;
    }

    public int getYearsInCompany() {
        return yearsInCompany;
    }

    public void setYearsInCompany(int yearsInCompany) {
        this.yearsInCompany = yearsInCompany;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "yearsInCompany=" + yearsInCompany +
                '}';
    }
}
