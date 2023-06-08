package com.example.iss_vanzari_versiunea2.controller;

import com.example.iss_vanzari_versiunea2.repository.ManagerRepository;
import com.example.iss_vanzari_versiunea2.service.AgentService;
import com.example.iss_vanzari_versiunea2.service.ManagerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    private AgentService agentService;
    private ManagerService managerService;

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;


    // Add event handlers and logic for the login functionality
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        String password = passwordField.getText();

        if (agentService.logAgent(name, password)){
            System.out.println("LOGGED IN AGENT!");
        } else if (managerService.logManager(name,password)) {
            System.out.println("LOGGED IN MANAGER!");
        }

    }

    public void setServices(AgentService as, ManagerService ms){
        this.agentService = as;
        this.managerService = ms;
    }

}
