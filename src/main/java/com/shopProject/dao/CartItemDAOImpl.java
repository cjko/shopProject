package com.shopProject.dao;

import com.shopProject.entity.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemDAOImpl implements CartItemDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CartItem> getCartItems() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<CartItem> query = session.createQuery("from CartItem");
        List<CartItem> cartItemsList = query.getResultList();
        session.getTransaction().commit();

        return cartItemsList;
    }
}
