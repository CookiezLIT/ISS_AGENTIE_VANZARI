package com.example.iss_vanzari_versiunea2.controller;


import com.example.iss_vanzari_versiunea2.model.Client;
import com.example.iss_vanzari_versiunea2.model.Product;
import com.example.iss_vanzari_versiunea2.service.AgentService;
import com.example.iss_vanzari_versiunea2.service.ClientService;
import com.example.iss_vanzari_versiunea2.service.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Product, String> pcolumn1;

    @FXML
    private TableColumn<Product, String> pcolumn2;

    @FXML
    private TableColumn<Product, Integer> pcolumn3;

    @FXML
    private TableColumn<Product, Float> pcolumn4;


    @FXML
    private TableColumn<Client, String> ccolumn1;

    @FXML
    private TableColumn<Client, String> ccolumn2;

    @FXML
    private TableColumn<Client, String> ccolumn3;

    @FXML
    private TableColumn<Client, String> ccolumn4;


    private void handleOrderButtonClicked() {

        String quantityText = quantityField.getText().trim();

        // Check if the quantity is a valid float
        try {
            int quantity = Integer.parseInt(quantityText);

            if (quantity <= 0) {
                showAlert(Alert.AlertType.ERROR, "Invalid Quantity", "Quantity must be greater than 0.");
            } else {
                // Check if a product is selected
                Product selectedProduct = productsTable.getSelectionModel().getSelectedItem();
                if (selectedProduct == null) {
                    showAlert(Alert.AlertType.ERROR, "No Product Selected", "Please select a product.");
                } else {
                    if (selectedProduct.getQuantity() < quantity) {
                        showAlert(Alert.AlertType.ERROR, "Not Enough Quanity", "Not enough quantity available.");
                    } else {
                        productService.deleteProductById(selectedProduct.getId());
                        selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
                        productService.saveProductObject(selectedProduct);
                        load_products();
                    }
                }
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Quantity", "Quantity must be a valid number.");
        }


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

        clientService.saveClient(firstName, lastName, phone, email, company, deliveryAddress);
        load_clients();

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
            clientService.deleteClient(selectedClient);
            load_clients();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addButton.setOnAction(event -> handleAddButtonClicked());
        removeButton.setOnAction(event -> handleRemoveButtonClicked());
        orderButton.setOnAction(event -> handleOrderButtonClicked());
        load_clients();
        load_products();
    }

    public void load_products() {
        // Retrieve the list of employees from the agent service
        ObservableList<Product> products = FXCollections.observableArrayList(productService.getAllProducts());

        pcolumn1.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        pcolumn2.setCellValueFactory(new PropertyValueFactory<Product, String>("countryOfOrigin"));
        pcolumn3.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        pcolumn4.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));


        // Set the items in the table view
        productsTable.setItems(products);
    }

    public void load_clients() {

        // Retrieve the list of employees from the agent service
        ObservableList<Client> clients = FXCollections.observableArrayList(clientService.findAllClients());

        ccolumn1.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        ccolumn2.setCellValueFactory(new PropertyValueFactory<Client, String>("phoneNumber"));
        ccolumn3.setCellValueFactory(new PropertyValueFactory<Client, String>("company"));
        ccolumn4.setCellValueFactory(new PropertyValueFactory<Client, String>("deliveryAddress"));


        // Set the items in the table view
        clientTable.setItems(clients);
    }

    public void setServices(AgentService as, ProductService ps, ClientService cs) {
        this.agentService = as;
        this.productService = ps;
        this.clientService = cs;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
