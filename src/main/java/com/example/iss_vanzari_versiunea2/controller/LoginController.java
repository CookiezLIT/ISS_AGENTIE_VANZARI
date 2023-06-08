package com.example.iss_vanzari_versiunea2.controller;

import com.example.iss_vanzari_versiunea2.HelloApplication;
import com.example.iss_vanzari_versiunea2.service.AgentService;
import com.example.iss_vanzari_versiunea2.service.ClientService;
import com.example.iss_vanzari_versiunea2.service.ManagerService;
import com.example.iss_vanzari_versiunea2.service.ProductService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private AgentService agentService;
    private ManagerService managerService;

    private ProductService productService;

    private ClientService clientService;

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;


    // Add event handlers and logic for the login functionality
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String password = passwordField.getText();

        if (agentService.logAgent(name, password)) {
            System.out.println("LOGGED IN AGENT!");
            // launch agent window
            showEmployeeView();
        } else if (managerService.logManager(name, password)) {
            System.out.println("LOGGED IN MANAGER!");
            //launch manager window
            showManagerView();

        }

    }

    private void showEmployeeView() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("employee-view.fxml"));

        EmployeeController employeeController = new EmployeeController();
        employeeController.setServices(agentService, productService, clientService);
        fxmlLoader.setController(employeeController);
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root, 1200, 1200);
        stage.setTitle("Employee View");
        stage.setScene(scene);
        stage.show();
    }

    private void showManagerView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("manager-view.fxml"));

        ManagerController managerController = new ManagerController();
        managerController.setServices(agentService, managerService);
        fxmlLoader.setController(managerController);
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root, 900, 1000);
        stage.setTitle("Manager View");
        stage.setScene(scene);
        stage.show();
    }

    public void setServices(AgentService as, ManagerService ms, ProductService ps, ClientService cs) {
        this.agentService = as;
        this.managerService = ms;
        this.productService = ps;
        this.clientService = cs;
    }

}
