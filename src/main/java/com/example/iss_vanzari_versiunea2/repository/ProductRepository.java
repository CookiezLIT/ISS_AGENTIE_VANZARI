package com.example.iss_vanzari_versiunea2.repository;

import com.example.iss_vanzari_versiunea2.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductRepository implements IRepository<Product> {

    private SessionFactory sessionFactory;

    public ProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product save(Product agent) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(agent);
        transaction.commit();
        session.close();
        return agent;
    }

    @Override
    public Product findById(long id) {
        Session session = sessionFactory.openSession();
        Product agent = session.get(Product.class, id);
        session.close();
        return agent;
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        List<Product> agents = session.createQuery("FROM Product", Product.class).list();
        session.close();
        return agents;
    }

    @Override
    public void delete(Product agent) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(agent);
        transaction.commit();
        session.close();
    }

}
