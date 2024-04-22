package com.example.capstonemapping.Controller;

//import ch.qos.logback.core.model.Model;
import com.example.capstonemapping.Entity.Student;
import com.example.capstonemapping.Entity.Teacher;
import com.example.capstonemapping.Repository.StudentRepository;
import com.example.capstonemapping.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;
    @GetMapping("/home")
    public ModelAndView home(ModelMap model){

        return new ModelAndView("home", model);
    }

    @GetMapping("/login")
        public ModelAndView login(ModelMap model) {
            return new ModelAndView("login", model);
        }

    @PostMapping("/login")
    public String login(String role, String username, String password, Model model) {
        System.out.println(username + " " + password);
        String redirect = "redirect:/login";
        if(role.equals("s")){
            Optional<Student> s = studentRepository.findById(username);
            if(!s.isEmpty()){
                if(s.get().getPswd().equals(password)){
                    redirect = "redirect:/student/profile/"+username;
                }
            }
        } else if (role.equals("t")) {
            Optional<Teacher> t = teacherRepository.findById(username);
            if(!t.isEmpty()){
                if(t.get().getPswd().equals(password)){
                    redirect = "redirect:/teacher/profile/"+username;
                }
            }
        }
        return redirect;
    }

//    @GetMapping(path = "/error")
//    public ResponseEntity<String> handleError(){
//
//    }
}
