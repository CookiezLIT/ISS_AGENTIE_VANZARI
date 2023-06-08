package com.example.iss_vanzari_versiunea2.repository;

import com.example.iss_vanzari_versiunea2.model.Agent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AgentRepository implements IRepository<Agent> {

    private SessionFactory sessionFactory;

    public AgentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Agent save(Agent agent) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(agent);
        transaction.commit();
        session.close();
        return agent;
    }

    @Override
    public Agent findById(long id) {
        Session session = sessionFactory.openSession();
        Agent agent = session.get(Agent.class, id);
        session.close();
        return agent;
    }

    @Override
    public List<Agent> findAll() {
        Session session = sessionFactory.openSession();
        List<Agent> agents = session.createQuery("SELECT * FROM Agent", Agent.class).list();
        session.close();
        return agents;
    }

    @Override
    public void delete(Agent agent) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(agent);
        transaction.commit();
        session.close();
    }

}