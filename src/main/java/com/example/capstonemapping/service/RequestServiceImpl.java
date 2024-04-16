package com.example.capstonemapping.service;

import com.example.capstonemapping.Entity.Request;
import com.example.capstonemapping.Entity.RequestStatus;
import com.example.capstonemapping.Entity.Supervisor;
import com.example.capstonemapping.Entity.Team;
import com.example.capstonemapping.Model.RequestModel;
import com.example.capstonemapping.Repository.RequestRepository;
import com.example.capstonemapping.Repository.SupervisorRepository;
import com.example.capstonemapping.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestServiceImpl implements RequestService {
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    SupervisorRepository supervisorRepository;
    @Autowired
    RequestRepository requestRepository;
    public Request saveRequest(RequestModel request){
        Team t = teamRepository.findById(request.getTeamID()).get();
        Supervisor s = supervisorRepository.findById(request.getTeacherID()).get();
        Request r = new Request();
        r.setTeam(t);
        r.setSupervisor(s);
        r.setIdea(request.getIdea());
        r.setInterestedDomain(request.getInterestedDomain());
        r.setRequestStatus(RequestStatus.REQUESTED);
        r = requestRepository.save(r);
        return r;
    }
}
