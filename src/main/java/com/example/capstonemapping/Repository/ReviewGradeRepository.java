package com.example.capstonemapping.Repository;

import com.example.capstonemapping.Entity.Project;
import com.example.capstonemapping.Entity.ReviewGrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewGradeRepository extends JpaRepository<ReviewGrade, Integer> {
    List<ReviewGrade> findByProject(Project p);
}
