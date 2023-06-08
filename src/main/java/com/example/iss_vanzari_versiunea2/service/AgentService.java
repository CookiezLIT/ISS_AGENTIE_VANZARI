package com.example.iss_vanzari_versiunea2.service;

import com.example.iss_vanzari_versiunea2.model.Agent;
import com.example.iss_vanzari_versiunea2.model.Product;
import com.example.iss_vanzari_versiunea2.repository.AgentRepository;
import com.example.iss_vanzari_versiunea2.repository.ProductRepository;

import java.util.List;
import java.util.Objects;

public class AgentService {

    private AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent saveAgent(String firstName, String lastName, String phoneNumber, String emailAddress, String username, String password, int years) {
        Agent agent = new Agent(firstName, lastName, phoneNumber, emailAddress, username, password, years);
        return agentRepository.save(agent);
    }

    public Agent findAgentById(long id) {
        return agentRepository.findById(id);
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public boolean logAgent(String username, String password){
        List<Agent> agents = agentRepository.findAll();

        for (Agent a : agents){
            if (Objects.equals(a.getUsername(), username) && Objects.equals(a.getPassword(), password)){
                return true;
            }
        }

        return false;

    }

    public void deleteAgent(String name) {
        Agent agent = agentRepository.findByName(name);
        if (agent != null) {
            agentRepository.delete(agent);
        } else {
            System.out.println("Agent with name " + name + " not found.");
        }
    }




}
