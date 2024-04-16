package com.example.capstonemapping.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ReviewGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int gradeId;

    @ManyToOne
    Project project;

    CapstonePhase phase;



    Grade grade;

//    @ElementCollection(targetClass = Review.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "reviews", joinColumns = @JoinColumn(name = "grade_id"))
//    @Column(name = "domain", nullable = false)
//    @Transient
//    List<Review> reviews = new ArrayList<>();

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public CapstonePhase getPhase() {
        return phase;
    }

    public void setPhase(CapstonePhase phase) {
        this.phase = phase;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public ReviewGrade(){}

}
