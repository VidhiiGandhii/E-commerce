package org.ncu.ecommerce_app.service;

import java.util.List;

import org.ncu.ecommerce_app.entity.Review;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(Long id);
    Review createReview(Review review);
    Review updateReview(Long id, Review review);
    void deleteReview(Long id);
}
