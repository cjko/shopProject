package com.shopProject;

import com.shopProject.entity.CartItem;
import com.shopProject.entity.Product;
import com.shopProject.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "com.shopProject")
public class AppConfig {
    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(CartItem.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Customer.class)
                    .buildSessionFactory();
    }
}
