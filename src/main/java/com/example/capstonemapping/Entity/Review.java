package com.example.capstonemapping.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int reviewId;

    public ReviewGrade getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(ReviewGrade reviewGrade) {
        this.reviewGrade = reviewGrade;
    }

    @ManyToOne
    ReviewGrade reviewGrade;

    @ManyToOne
    Teacher teacher;


    String feedback;

    public Review(){}

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
