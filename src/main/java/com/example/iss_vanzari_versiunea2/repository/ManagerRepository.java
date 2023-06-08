package com.example.iss_vanzari_versiunea2.repository;

import com.example.iss_vanzari_versiunea2.model.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ManagerRepository implements IRepository<Manager> {

    private SessionFactory sessionFactory;

    public ManagerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Manager save(Manager agent) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(agent);
        transaction.commit();
        session.close();
        return agent;
    }

    @Override
    public Manager findById(long id) {
        Session session = sessionFactory.openSession();
        Manager agent = session.get(Manager.class, id);
        session.close();
        return agent;
    }

    @Override
    public List<Manager> findAll() {
        Session session = sessionFactory.openSession();
        List<Manager> agents = session.createQuery("FROM Manager", Manager.class).list();
        session.close();
        return agents;
    }

    @Override
    public void delete(Manager agent) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(agent);
        transaction.commit();
        session.close();
    }

}
