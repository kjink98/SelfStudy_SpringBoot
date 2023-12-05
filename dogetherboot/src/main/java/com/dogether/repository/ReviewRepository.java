package com.dogether.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dogether.domain.Review;
import com.dogether.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final ReviewMapper reviewMapper;

    public List<Review> getDataAll(int place_id) {
        List<Review> list = reviewMapper.selectAll(place_id);
        return list;
    }
    
    public boolean insertReview(Review review) {
        int result = reviewMapper.insertReview(review);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Review selectReview(int review_id) {
        return reviewMapper.selectReview(review_id);
    }

    public void updateReview(Review review) {
        reviewMapper.updateReview(review);
        return;
    }

    public void deleteReview(int review_id) {
        reviewMapper.deleteReview(review_id);
        return;
    }

}
