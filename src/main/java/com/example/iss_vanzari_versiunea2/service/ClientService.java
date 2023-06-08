package com.example.iss_vanzari_versiunea2.service;

import com.example.iss_vanzari_versiunea2.model.Client;
import com.example.iss_vanzari_versiunea2.repository.ClientRepository;

import java.util.List;

public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(String firstName, String lastName, String phoneNumber, String emailAddress, String company, String deliveryAddress) {
        Client client = new Client(firstName,lastName,phoneNumber,emailAddress,company,deliveryAddress);
        return clientRepository.save(client);
    }

    public Client findClientById(long id) {
        return clientRepository.findById(id);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }
}
