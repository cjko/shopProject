package com.shopProject.dao;

import com.shopProject.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProducts() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Product> query = session.createQuery("from Product", Product.class);
        List<Product> productList = query.getResultList();
        session.getTransaction().commit();
        return productList;
    }
}
