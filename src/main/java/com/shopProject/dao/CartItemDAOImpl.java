package com.shopProject.dao;

import com.shopProject.entity.CartItem;
import com.shopProject.entity.Customer;
import com.shopProject.entity.Product;
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

    @Override
    public void createCartItem(int quantity, int customerId, int productId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, customerId);
        Product product = session.get(Product.class, productId);
        CartItem cartItem = new CartItem(quantity, customer, product);
        session.save(cartItem);
        session.getTransaction().commit();
    }

    @Override
    public List<CartItem> getCartItemsByCustomerId(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<CartItem> query = session.createQuery("FROM CartItem c WHERE c.customer.id = :customerId", CartItem.class)
                                        .setParameter("customerId", customerId);
        List<CartItem> cartItemList = query.getResultList();
        session.getTransaction().commit();
        return cartItemList;
    }

    @Override
    public void deleteCartItem(int customerId, int productId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<CartItem> query = session.createQuery("FROM CartItem c " +
                                                    "WHERE c.customer.id = :customerId " +
                                                    "AND c.product.id = :productId", CartItem.class)
                .setParameter("customerId", customerId)
                .setParameter("productId", productId);
        try {
            CartItem cartItem = query.getSingleResult();
            session.remove(cartItem);
            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().commit();
        }

    }
}
