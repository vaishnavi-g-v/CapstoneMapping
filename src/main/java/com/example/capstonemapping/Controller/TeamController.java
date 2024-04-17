package com.example.capstonemapping.Controller;

import com.example.capstonemapping.Entity.Request;
import com.example.capstonemapping.Entity.Team;
import com.example.capstonemapping.Repository.RequestRepository;
import com.example.capstonemapping.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private RequestRepository requestRepository;
    @GetMapping(path = "/{id}")
    public String getTeam(@PathVariable Integer id, @RequestParam String viewerId, Model model){

        Optional<Team> t =  teamRepository.findById(id);
        Team team = t.get();
        model.addAttribute("username", viewerId);

        return "teampage";
    }

    @GetMapping(path = "/{id}/requests")
    public @ResponseBody List<Request> getRequests(@PathVariable Integer id) {
        List<Request> requests = requestRepository.findByTeam(teamRepository.findById(id).get());
        return requests;
    }

}
