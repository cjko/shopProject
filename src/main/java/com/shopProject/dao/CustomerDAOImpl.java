package com.shopProject.dao;

import com.shopProject.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
        List<Customer> customerList = query.getResultList();
        session.getTransaction().commit();
        return customerList;
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Customer> query = session.createQuery("FROM Customer c WHERE c.id = :id", Customer.class)
                                        .setParameter("id",id);
        try {
            Customer customer = query.getSingleResult();
            session.getTransaction().commit();
            return customer;
        } catch (Exception e) {
            session.getTransaction().commit();
            return null;
        }
    }

    @Override
    public void createCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    @Override
    public List<Customer> getCustomersByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Customer> query = session.createQuery("FROM Customer c WHERE c.email = :email")
                                        .setParameter("email", email);
        List<Customer> customerList = query.getResultList();
        session.getTransaction().commit();
        return customerList;
    }
}
