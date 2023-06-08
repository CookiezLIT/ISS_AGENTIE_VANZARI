package com.example.iss_vanzari_versiunea2.model;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Employee extends Person{
    private String username;
    private String password;


    public Employee(String firstName, String lastName, String phoneNumber, String emailAddress, String username, String password) {
        super(firstName, lastName, phoneNumber, emailAddress);
        this.username = username;
        this.password = password;
    }

    public Employee() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
