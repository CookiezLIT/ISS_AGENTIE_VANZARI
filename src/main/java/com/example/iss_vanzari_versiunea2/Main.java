package com.example.iss_vanzari_versiunea2;

import com.example.iss_vanzari_versiunea2.model.Agent;
import com.example.iss_vanzari_versiunea2.repository.AgentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        // Create Hibernate SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // Create an instance of Agent
        Agent agent = new Agent("John", "Doe", "1234567890", "john.doe@example.com",
                "johndoe", "password", 5);

        AgentRepository agent_repo = new AgentRepository(sessionFactory);
        agent_repo.save(agent);

        // Close the SessionFactory
        sessionFactory.close();
    }
}
