package com.example.capstonemapping.Controller;

import com.example.capstonemapping.Entity.Review;
import com.example.capstonemapping.Entity.Student;
import com.example.capstonemapping.Entity.Supervisor;
import com.example.capstonemapping.Entity.Teacher;
import com.example.capstonemapping.Repository.ReviewRepository;
import com.example.capstonemapping.Repository.SupervisorRepository;
import com.example.capstonemapping.Repository.TeacherRepository;
import com.example.capstonemapping.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SupervisorRepository supervisorRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping(path="")
    public @ResponseBody Iterable<Teacher> getAllTeachers() {
        // This returns a JSON or XML with the users
        return teacherRepository.findAll();
    }

    @GetMapping(path="/profile/{id}")
    public @ResponseBody Teacher getTeacherById(@PathVariable String id, Model model) {
        System.out.println("Teacher reached");
        Optional<Teacher> t = teacherRepository.findById(id);
        System.out.println(t);

        Optional<Supervisor> s = supervisorRepository.findById(id);
        System.out.println(s);


        Teacher p = t.get();
        boolean isSupervisor = false;
        if(!s.isEmpty()){
            isSupervisor = true;
        }

        model.addAttribute("username", id);
        model.addAttribute("first_name",teacher. )

        return p;
    }

    @GetMapping(path="/supervisor/{id}")
    public @ResponseBody Supervisor getSupervisorById(@PathVariable String id) {
        Optional<Supervisor> s = supervisorRepository.findById(id);
        return s.get();
    }

    @GetMapping(path = "/{id}/review")
    public @ResponseBody List<Review> getReviews(@PathVariable String id) {
        List<Review> reviews =  reviewRepository.findByTeacher(teacherRepository.findById(id).get());
        return reviews;
    }

    @PatchMapping(path = "/review/{rid}")
    public @ResponseBody Review addFeedback(@PathVariable int rid, @RequestBody String feedback){
        Review r = reviewRepository.findById(rid).get();
        r.setFeedback(feedback);
        r = reviewRepository.save(r);
        return r;
    }
}
