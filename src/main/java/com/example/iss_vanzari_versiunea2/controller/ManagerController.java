package com.example.iss_vanzari_versiunea2.controller;

import com.example.iss_vanzari_versiunea2.model.Agent;
import com.example.iss_vanzari_versiunea2.service.AgentService;
import com.example.iss_vanzari_versiunea2.service.ManagerService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerController implements Initializable{

    private AgentService agentService;
    private ManagerService managerService;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private Button removeEmployeeButton;

    @FXML
    private TableView<Agent>employeeTableView;

    @FXML
    private TableColumn<Agent, String> column1;

    @FXML
    private TableColumn<Agent, String>column2;

    @FXML
    private TableColumn<Agent, String> column3;

    @FXML
    private TableColumn<Agent, String> column4;

    @FXML
    private TableColumn<Agent, Integer> column5;


    public void setServices(AgentService as, ManagerService ms){
        this.agentService = as;
        this.managerService = ms;
    }

    public void loadEmployees() {
        // Retrieve the list of employees from the agent service
        ObservableList<Agent> employees = FXCollections.observableArrayList(agentService.getAllAgents());

        column1.setCellValueFactory(new PropertyValueFactory<Agent, String>("firstName"));
        column2.setCellValueFactory(new PropertyValueFactory<Agent, String>("lastName"));
        column3.setCellValueFactory(new PropertyValueFactory<Agent, String>("phoneNumber"));
        column4.setCellValueFactory(new PropertyValueFactory<Agent, String>("emailAddress"));
        column5.setCellValueFactory(new PropertyValueFactory<Agent, Integer>("yearsInCompany"));


        // Set the items in the table view
        employeeTableView.setItems(employees);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadEmployees();
    }
}
