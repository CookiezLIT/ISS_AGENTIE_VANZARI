package com.example.iss_vanzari_versiunea2.controller;

import com.example.iss_vanzari_versiunea2.model.Client;
import com.example.iss_vanzari_versiunea2.model.Product;
import com.example.iss_vanzari_versiunea2.service.AgentService;
import com.example.iss_vanzari_versiunea2.service.ClientService;
import com.example.iss_vanzari_versiunea2.service.ManagerService;
import com.example.iss_vanzari_versiunea2.service.ProductService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    private AgentService agentService;

    private ProductService productService;

    private ClientService clientService;

    @FXML
    private TableView<Product> productsTable;

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private Button orderButton;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField fnameField;

    @FXML
    private TextField lnameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField deliveryField;

    @FXML
    private TextField companyField;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private TableColumn<Product, String> productsColumn1;

    @FXML
    private TableColumn<Product, String> productsColumn2;

    @FXML
    private TableColumn<Client, String> clientColumn1;

    @FXML
    private TableColumn<Client, String> clientColumn2;


    private void handleOrderButtonClicked() {
        // Handle order button click event
        String quantity = quantityField.getText();
        // Perform necessary operations with the provided quantity
    }

    private void handleAddButtonClicked() {
        // Handle add button click event
        String firstName = fnameField.getText();
        String lastName = lnameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String deliveryAddress = deliveryField.getText();
        String company = companyField.getText();

        // Perform necessary operations to add a client
        // For example, create a new Client object and add it to the client table

        // Clear the input fields
        fnameField.clear();
        lnameField.clear();
        phoneField.clear();
        emailField.clear();
        deliveryField.clear();
        companyField.clear();
    }

    private void handleRemoveButtonClicked() {
        // Handle remove button click event
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            // Perform necessary operations to remove the selected client
            // For example, remove the selected client from the client table
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addButton.setOnAction(event -> handleAddButtonClicked());
        removeButton.setOnAction(event -> handleRemoveButtonClicked());
        orderButton.setOnAction(event -> handleOrderButtonClicked());
    }

    public void setServices(AgentService as, ProductService ps, ClientService cs){
        this.agentService = as;
        this.productService = ps;
        this.clientService = cs;
    }

}
