package com.example.capstonemapping.Controller;
import com.example.capstonemapping.Entity.Student;
import com.example.capstonemapping.Entity.Team;
import com.example.capstonemapping.Model.TeamFormModel;
import com.example.capstonemapping.Repository.StudentRepository;
import com.example.capstonemapping.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping(path="/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeamRepository teamRepository;


    // testing
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }



    @PostMapping(path="/redirect")
    public String validate(@RequestParam Map<String, Object> teamFormModel, @RequestParam String studentId){
        System.out.println("Post Mapping redirect");
        List<String> values = new ArrayList<>();
        values.add((String) teamFormModel.get("srn1"));
        values.add((String) teamFormModel.get("srn2"));
        values.add((String) teamFormModel.get("srn3"));
        values.add((String) teamFormModel.get("srn4"));
        List<Student> students = (List<Student>)studentRepository.findAllById(values);
        if(students.size() == values.size()){
            Team n = new Team((String) teamFormModel.get("teamName").toString());
            n = teamRepository.save(n);
            for(String id : values){
                Student s = studentRepository.findById(id).get();
                s.setTeam(n);
                studentRepository.save(s);
            }
//            System.out.println(n.getTeamID());


        }
        System.out.println(teamFormModel);
        return "redirect:/student/profile/"+studentId;
    }

    @GetMapping(path = "/teamform")
    public String createTeam(@RequestParam String studentId, Model model){
        System.out.println("");
        model.addAttribute("username", studentId);
        System.out.println("here");
        System.out.println(model.getAttribute("first_name"));
        return "teamformpage";
    }
    @GetMapping(path="/profile/{srn}")
    public String getStudentById(@PathVariable String srn, Model model) {
        System.out.println("REACHED");
        Optional<Student> s = studentRepository.findById(srn);
        Student student = s.get();
        model.addAttribute("first_name", student.getFName());
        model.addAttribute("last_name", student.getLname());
        model.addAttribute("email_id", student.getEmail());
        model.addAttribute("teamEligibility", student.teamEligibility());
        model.addAttribute("hasTeam", student.hasTeam());
        model.addAttribute("username", srn);
        System.out.println(student.hasTeam());
        return "studentprofile";
    }


}


