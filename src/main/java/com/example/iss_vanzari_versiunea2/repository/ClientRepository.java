package com.example.iss_vanzari_versiunea2.repository;

import com.example.iss_vanzari_versiunea2.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ClientRepository implements IRepository<Client> {

    private SessionFactory sessionFactory;

    public ClientRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Client save(Client agent) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(agent);
        transaction.commit();
        session.close();
        return agent;
    }

    @Override
    public Client findById(long id) {
        Session session = sessionFactory.openSession();
        Client agent = session.get(Client.class, id);
        session.close();
        return agent;
    }

    @Override
    public List<Client> findAll() {
        Session session = sessionFactory.openSession();
        List<Client> agents = session.createQuery("FROM Client", Client.class).list();
        session.close();
        return agents;
    }

    @Override
    public void delete(Client agent) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(agent);
        transaction.commit();
        session.close();
    }

}
