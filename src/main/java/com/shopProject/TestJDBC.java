package com.shopProject;

import com.shopProject.entity.CartItem;
import com.shopProject.entity.Customer;
import com.shopProject.entity.Product;
import com.shopProject.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class TestJDBC {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(CartItem.class)
                                            .addAnnotatedClass(Review.class)
                                            .addAnnotatedClass(Product.class)
                                            .addAnnotatedClass(Customer.class)
                                            .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // Create Product
            Product tempProduct = new Product("Apple","image.url","A red fruit",1.23,45);
            session.save(tempProduct);

            // Create Customer
            Date date = new Date(12341343434L);
            Customer tempCustomer = new Customer("jao.colin@gmail.com","Colin", "Jao", date,"pwhash123","salt");
            session.save(tempCustomer);

            // Create Cart Item
            CartItem tempCartItem = new CartItem(123, tempCustomer,tempProduct);
            session.save(tempCartItem);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
