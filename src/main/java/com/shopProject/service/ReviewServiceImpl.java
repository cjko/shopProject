package com.shopProject.service;

import com.shopProject.dao.ReviewDAO;
import com.shopProject.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewDAO reviewDAO;

    @Override
    public List<Review> getReviews() {
        return reviewDAO.getReviews();
    }
}
