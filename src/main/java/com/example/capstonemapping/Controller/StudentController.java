package com.example.capstonemapping.Controller;
import com.example.capstonemapping.Entity.Student;
import com.example.capstonemapping.Entity.Team;
import com.example.capstonemapping.Repository.StudentRepository;
import com.example.capstonemapping.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeamRepository teamRepository;


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    @GetMapping(path="/{srn}")
    public String getStudentById(@PathVariable String srn, Model model) {
        System.out.println("REACHED");
        Optional<Student> s = studentRepository.findById(srn);
        Student student = s.get();
        model.addAttribute("first_name", student.getFName());
        model.addAttribute("last_name", student.getLname());
        model.addAttribute("email_id", student.getEmail());
        return "studentprofile";
    }

    @GetMapping(path="/teamform")
    public @ResponseBody Team validate(@RequestParam String[] values, @RequestParam String name){
        List<Student> students = (List<Student>)studentRepository.findAllById(Arrays.asList(values));
        if(students.size() == values.length){
            Team n = new Team(name);
            n = teamRepository.save(n);
            for(String id : values){
                Student s = studentRepository.findById(id).get();
                s.setTeam(n);
                studentRepository.save(s);
            }
//            System.out.println(n.getTeamID());

            return n;
        }
        return null;

    }
}


