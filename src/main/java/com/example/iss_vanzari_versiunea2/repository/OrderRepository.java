//package com.example.iss_vanzari_versiunea2.repository;
//
//import com.example.iss_vanzari_versiunea2.model.Order;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import java.util.List;
//
//public class OrderRepository implements IRepository<Order> {
//
//    private SessionFactory sessionFactory;
//
//    public OrderRepository(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public Order save(Order agent) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.saveOrUpdate(agent);
//        transaction.commit();
//        session.close();
//        return agent;
//    }
//
//    @Override
//    public Order findById(long id) {
//        Session session = sessionFactory.openSession();
//        Order agent = session.get(Order.class, id);
//        session.close();
//        return agent;
//    }
//
//    @Override
//    public List<Order> findAll() {
//        Session session = sessionFactory.openSession();
//        List<Order> agents = session.createQuery("SELECT * FROM Order", Order.class).list();
//        session.close();
//        return agents;
//    }
//
//    @Override
//    public void delete(Order agent) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(agent);
//        transaction.commit();
//        session.close();
//    }
//
//}
