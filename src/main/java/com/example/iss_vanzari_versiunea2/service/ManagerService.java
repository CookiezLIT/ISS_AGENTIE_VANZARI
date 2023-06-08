package com.example.iss_vanzari_versiunea2.service;
import com.example.iss_vanzari_versiunea2.model.Manager;
import com.example.iss_vanzari_versiunea2.repository.ManagerRepository;

import java.util.List;
import java.util.Objects;

public class ManagerService {

    private ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager saveManager(String firstName, String lastName, String phoneNumber, String emailAddress,
                               String username, String password, String department) {
        Manager manager = new Manager(firstName, lastName, phoneNumber, emailAddress, username, password, department);
        return managerRepository.save(manager);
    }

    public Manager findManagerById(long id) {
        return managerRepository.findById(id);
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public void deleteManagerById(int id) {
        Manager manager = managerRepository.findById(id);
        if (manager != null) {
            managerRepository.delete(manager);
        } else {
            // Handle case when manager with the given name doesn't exist
        }
    }

    public boolean logManager(String username, String password){
        List<Manager> managers = managerRepository.findAll();

        for (Manager a : managers){
            if (Objects.equals(a.getUsername(), username) && Objects.equals(a.getPassword(), password)){
                return true;
            }
        }
        return false;

    }

}
