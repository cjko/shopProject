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
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customerList = query.getResultList();
        session.getTransaction().commit();
        return customerList;
    }
}
