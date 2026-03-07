package com.assignment.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.assignment.dao.OrderDAO;
import com.assignment.entity.Order;
import com.assignment.util.HibernateUtil;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String saveOrder(Order order) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(order);

        tx.commit();
        session.close();

        return "Order Saved";
    }

    @Override
    public String updateOrder(Order order) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(order);

        tx.commit();
        session.close();

        return "Order Updated";
    }

    @Override
    public String deleteOrderById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Order o = session.get(Order.class, id);

        if (o != null) {
            session.delete(o);
        }

        tx.commit();
        session.close();

        return "Order Deleted";
    }

    @Override
    public Order getOrderById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Order o = session.get(Order.class, id);
        session.close();

        return o;
    }
    
}