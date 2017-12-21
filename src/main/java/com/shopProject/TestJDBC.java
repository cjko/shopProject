package com.shopProject;

import com.shopProject.entity.Product;
import com.shopProject.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestJDBC {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Product.class)
                                            .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Product tempProduct = new Product("Apple","image.url","A red fruit",1.23,45);
//            session.save(tempProduct);
            Date date = new SimpleDateFormat("MM-dd-yyyy").parse("04-02-1991");

            User tempUser = new User("jao.colin@gmail.com","Colin", "Jao", date,"pwhash123","salt");

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
