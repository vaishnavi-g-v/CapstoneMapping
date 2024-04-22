package com.example.capstonemapping.Controller;

import com.example.capstonemapping.Entity.Project;
import com.example.capstonemapping.Entity.Request;
import com.example.capstonemapping.Entity.Student;
import com.example.capstonemapping.Entity.Team;
import com.example.capstonemapping.Repository.ProjectRepository;
import com.example.capstonemapping.Repository.RequestRepository;
import com.example.capstonemapping.Repository.StudentRepository;
import com.example.capstonemapping.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProjectRepository  projectRepository;

    @GetMapping(path = "/{id}")
    public String getTeam(@PathVariable Integer id, @RequestParam String viewerId, Model model){

        Optional<Team> t =  teamRepository.findById(id);
        Team team = t.get();
        List<Student> students = studentRepository.findByTeam(team);
        Optional<Project> p = Optional.ofNullable(projectRepository.findByTeam(team));
        boolean hasProject = p.isPresent();
        boolean isStudent = viewerId.charAt(0) == 'P' ? true : false;
        List<String> columns = new ArrayList<>();
        model.addAttribute("team_name", team.getTeamName());
        model.addAttribute("team_id", team.getTeamID());
        model.addAttribute("isStudent", isStudent);
        model.addAttribute("hadProject", hasProject);
        model.addAttribute("username", viewerId);




        
        return "teampage";
    }

    // id -- teamID
    // viewID -- the person viewing
    //        -- P -- student
    //        -- T -- teacher
    @GetMapping(path = "/{id}/requests")
    public @ResponseBody List<Request> getRequests(@PathVariable Integer id, String viewerId) {
        List<Request> requests = requestRepository.findByTeam(teamRepository.findById(id).get());
        return requests;
    }

    @GetMapping(path = "/makerequest/{id}")

}
