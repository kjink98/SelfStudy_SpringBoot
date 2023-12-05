package com.dogether.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogether.domain.Review;
import com.dogether.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> list(int place_id) {
        List<Review> reviews = reviewRepository.getDataAll(place_id);
        return reviews;
    }

    public boolean insertReview(Review review) {
        return reviewRepository.insertReview(review);
    }

    public Review detail(int review_id) {
        return reviewRepository.selectReview(review_id);
    }

    public void update(Review review) {
        reviewRepository.updateReview(review);
        return;
    }

    public void delete(int review_id) {
        reviewRepository.deleteReview(review_id);
        return;
    }

}
