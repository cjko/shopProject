package com.shopProject.controller;

import com.shopProject.entity.Review;
import com.shopProject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews/**")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/")
    public List<Review> getReviews() {
        return reviewService.getReviews();
    }
}
