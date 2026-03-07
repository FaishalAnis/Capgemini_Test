package com.assignment.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.assignment.dao.CustomerDAO;
import com.assignment.entity.Customer;
import com.assignment.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public String saveCustomer(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(customer);

        tx.commit();
        session.close();

        return "Customer Saved Successfully";
    }

    @Override
    public String updateCustomer(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(customer);

        tx.commit();
        session.close();

        return "Customer Updated";
    }

    @Override
    public String deleteCustomerById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer c = session.get(Customer.class, id);

        if (c != null) {
            session.delete(c);
        }

        tx.commit();
        session.close();

        return "Customer Deleted";
    }

    @Override
    public Customer getCustomerById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer c = session.get(Customer.class, id);
        session.close();

        return c;
    }

    @Override
    public List<Customer> getAllCustomers() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Customer> q = session.createQuery("from Customer", Customer.class);
        List<Customer> list = q.list();

        session.close();

        return list;
    }

    @Override
    public Customer getCustomerByEmail(String email) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Customer> q = session.createQuery(
                "FROM Customer c WHERE c.email = :email",
                Customer.class);

        q.setParameter("email", email);

        List<Customer> list = q.list();

        session.close();

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }
}