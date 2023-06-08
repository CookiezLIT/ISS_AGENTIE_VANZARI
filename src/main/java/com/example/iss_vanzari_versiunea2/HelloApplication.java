package com.example.iss_vanzari_versiunea2;

import com.example.iss_vanzari_versiunea2.controller.LoginController;
import com.example.iss_vanzari_versiunea2.repository.AgentRepository;
import com.example.iss_vanzari_versiunea2.repository.ClientRepository;
import com.example.iss_vanzari_versiunea2.repository.ManagerRepository;
import com.example.iss_vanzari_versiunea2.repository.ProductRepository;
import com.example.iss_vanzari_versiunea2.service.AgentService;
import com.example.iss_vanzari_versiunea2.service.ClientService;
import com.example.iss_vanzari_versiunea2.service.ManagerService;
import com.example.iss_vanzari_versiunea2.service.ProductService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //initiate controllers, services, repos

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        AgentRepository agent_repo = new AgentRepository(sessionFactory);
        ClientRepository clientRepository = new ClientRepository(sessionFactory);
        ProductRepository productRepository = new ProductRepository(sessionFactory);
        ManagerRepository managerRepository = new ManagerRepository(sessionFactory);

        AgentService agentService = new AgentService(agent_repo);
        ManagerService managerService = new ManagerService(managerRepository);
        ProductService productService = new ProductService(productRepository);
        ClientService clientService = new ClientService(clientRepository);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-design.fxml"));
        Parent root = fxmlLoader.load();
        LoginController loginController = fxmlLoader.getController();
        loginController.setServices(agentService,managerService); //todo add all services here



        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Welcome to the Sales App!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}