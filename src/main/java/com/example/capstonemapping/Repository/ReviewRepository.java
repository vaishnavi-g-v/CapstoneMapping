package com.example.capstonemapping.Repository;

import com.example.capstonemapping.Entity.Review;
import com.example.capstonemapping.Entity.ReviewGrade;
import com.example.capstonemapping.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByReviewGrade(ReviewGrade reviewGrade);

    List<Review> findByTeacher(Teacher teacher);
}
