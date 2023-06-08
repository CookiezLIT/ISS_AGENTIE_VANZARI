package com.example.iss_vanzari_versiunea2;

import com.example.iss_vanzari_versiunea2.model.Agent;
import com.example.iss_vanzari_versiunea2.model.Client;
import com.example.iss_vanzari_versiunea2.model.Manager;
import com.example.iss_vanzari_versiunea2.model.Product;
import com.example.iss_vanzari_versiunea2.repository.AgentRepository;
import com.example.iss_vanzari_versiunea2.repository.ClientRepository;
import com.example.iss_vanzari_versiunea2.repository.ManagerRepository;
import com.example.iss_vanzari_versiunea2.repository.ProductRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create Hibernate SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // TEST FOR AGENTS

        // Create an instance of Agent
        Agent agent = new Agent("John", "Doe", "1234567890", "john.doe@example.com",
                "johndoe", "password", 5);

        AgentRepository agent_repo = new AgentRepository(sessionFactory);
        agent_repo.save(agent);

        //TEST FOR CLIENTS
        // Create a client repository
        ClientRepository clientRepository = new ClientRepository(sessionFactory);

        // Create a new client
        Client client = new Client("John", "Doe", "123456789", "john.doe@example.com", "ABC Company", "123 Main St");

        // Save the client
        clientRepository.save(client);
        System.out.println("Saved client: " + client);

        // Find the client by ID
        long clientId = client.getId();
        Client retrievedClient = clientRepository.findById(clientId);
        System.out.println("Retrieved client: " + retrievedClient);

        // Update the client's company
        retrievedClient.setCompany("XYZ Company");
        clientRepository.save(retrievedClient);
        System.out.println("Updated client: " + retrievedClient);

        // Delete the client
        clientRepository.delete(retrievedClient);
        System.out.println("Deleted client: " + retrievedClient);


        //TEST FOR PRODUCTS

        // Create a ProductRepository instance
        ProductRepository productRepository = new ProductRepository(sessionFactory);

        // Create a new product
        Product product1 = new Product("Product 1", "Country 1", 10, 9.99f);

        // Save the product
        productRepository.save(product1);
        System.out.println("Product saved: " + product1);

        // Find the product by ID
        long productId = product1.getId();
        Product foundProduct = productRepository.findById(productId);
        System.out.println("Product found by ID: " + foundProduct);

        // Find all products
        List<Product> allProducts = productRepository.findAll();
        System.out.println("All products:");
        for (Product product : allProducts) {
            System.out.println(product);
        }

        // Update the product
        product1.setName("Updated Product");
        product1.setPrice(19.99f);
        productRepository.save(product1);
        System.out.println("Product updated: " + product1);

        // Delete the product
        productRepository.delete(product1);
        System.out.println("Product deleted: " + product1);


        // TEST FOR MANAGER

        // Create a manager repository
        ManagerRepository managerRepository = new ManagerRepository(sessionFactory);

        // Create a new manager
        Manager manager = new Manager("Jane", "Smith", "987654321", "jane.smith@example.com", "Marketing", "asd", "a");

        // Save the manager
        managerRepository.save(manager);
        System.out.println("Saved manager: " + manager);

        // Find the manager by ID
        long managerId = manager.getId();
        Manager retrievedManager = managerRepository.findById(managerId);
        System.out.println("Retrieved manager: " + retrievedManager);

        // Update the manager's department
        retrievedManager.setDepartament("Sales");
        managerRepository.save(retrievedManager);
        System.out.println("Updated manager: " + retrievedManager);

        // Delete the manager
        managerRepository.delete(retrievedManager);
        System.out.println("Deleted manager: " + retrievedManager);

        // Find all managers
        List<Manager> allManagers = managerRepository.findAll();
        System.out.println("All managers:");
        for (Manager m : allManagers) {
            System.out.println(m);
        }






        // Close the SessionFactory
        sessionFactory.close();
    }
}
