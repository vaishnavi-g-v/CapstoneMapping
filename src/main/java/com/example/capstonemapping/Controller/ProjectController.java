package com.example.capstonemapping.Controller;

import com.example.capstonemapping.Entity.*;
import com.example.capstonemapping.Model.ReviewGradeModel;
import com.example.capstonemapping.Model.ReviewsModel;
import com.example.capstonemapping.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SupervisorRepository supervisorRepository;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    ReviewGradeRepository reviewGradeRepository;

    @Autowired
    ReviewRepository reviewRepository;
    @GetMapping(path = "/")
    public @ResponseBody Project getProjectForStudent(@RequestParam String studentId){
        // if id starts from P -- student, else teacher
        Project p = projectRepository.findByTeam(studentRepository.findById(studentId).get().getTeam());

        return p;
    }

    @GetMapping(path = "/{projectId}/reviews")
    public @ResponseBody List<ReviewsModel> getReviews(@PathVariable int projectId){
        Project p = projectRepository.findById(projectId).get();
        List<ReviewGrade> reviewGrades =  reviewGradeRepository.findByProject(p);
        List<ReviewsModel> reviewsList = new ArrayList<>();

        for(ReviewGrade rg : reviewGrades){
            List<Review> reviews = reviewRepository.findByReviewGrade(rg);
            ReviewsModel reviewsModel = new ReviewsModel();
            reviewsModel.setReviewGrade(rg);
            reviewsModel.setReviews(reviews);
            reviewsList.add(reviewsModel);
            // rg.setReviews(reviews);
        }
        return reviewsList;
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<Project> getProjectsForSupervisor(@RequestParam String teacherId) {
        List<Project> projects = projectRepository.findBySupervisor(supervisorRepository.findById(teacherId).get());
        return projects;
    }

    @PostMapping(path = "/")
    public @ResponseBody Project createProject(@RequestParam int requestId){
        Request r = requestRepository.findById(requestId).get();
        Project p = new Project();
        p.setDomain(r.getInterestedDomain());
        p.setProblemStatement(r.getIdea());
        p.setSupervisor(r.getSupervisor());
        p.setTeam(r.getTeam());
        p.setPhase(CapstonePhase.FIRST);
        p = projectRepository.save(p);
        return p;
    }

    @PostMapping(path = "/assignreviewer")
    public @ResponseBody ReviewsModel createReviewGrade(@RequestBody ReviewGradeModel reviewGradeModel){
        Project p = projectRepository.findById(reviewGradeModel.getProjectId()).get();
        ReviewGrade rg = new ReviewGrade();
        rg.setProject(p);
        rg.setPhase(reviewGradeModel.getPhase());
        rg = reviewGradeRepository.save(rg);
        List<Review> reviews = new ArrayList<>();
        for(String teacherId : reviewGradeModel.getTeacherIds()){
            Teacher teacher = teacherRepository.findById(teacherId).get();
            Review review = new Review();
            review.setTeacher(teacher);
            review.setReviewGrade(rg);
            review = reviewRepository.save(review);
            reviews.add(review);
        }
        ReviewsModel reviewsModel = new ReviewsModel();
        reviewsModel.setReviewGrade(rg);
        reviewsModel.setReviews(reviews);
//        rg.setReviews(reviews);
        // make model and add the reviews list to the model, return model
        return reviewsModel;
    }

}
