package com.example.capstonemapping.Controller;

import com.example.capstonemapping.Entity.Request;
import com.example.capstonemapping.Entity.Team;
import com.example.capstonemapping.Repository.RequestRepository;
import com.example.capstonemapping.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public @ResponseBody Team getTeam(@PathVariable Integer id){

        Optional<Team> t =  teamRepository.findById(id);
        return t.get();
    }

    @GetMapping(path = "/{id}/requests")
    public @ResponseBody List<Request> getRequests(@PathVariable Integer id) {
        List<Request> requests = requestRepository.findByTeam(teamRepository.findById(id).get());
        return requests;
    }

}
