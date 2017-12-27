package com.shopProject.dao;

import com.shopProject.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Review> getReviews() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Review> query = session.createQuery("from Review", Review.class);
        List<Review> reviewList = query.getResultList();
        session.getTransaction().commit();
        return reviewList;
    }
}
