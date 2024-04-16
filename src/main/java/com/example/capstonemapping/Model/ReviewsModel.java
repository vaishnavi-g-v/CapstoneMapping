package com.example.capstonemapping.Model;

import com.example.capstonemapping.Entity.Review;
import com.example.capstonemapping.Entity.ReviewGrade;

import java.util.ArrayList;
import java.util.List;

public class ReviewsModel {
    ReviewGrade reviewGrade;

    List<Review> reviews = new ArrayList<>();

    public ReviewsModel(){}

    public ReviewGrade getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(ReviewGrade reviewGrade) {
        this.reviewGrade = reviewGrade;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
