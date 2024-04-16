package com.example.capstonemapping.Controller;

import com.example.capstonemapping.Entity.Project;
import com.example.capstonemapping.Entity.Request;
import com.example.capstonemapping.Entity.RequestStatus;
import com.example.capstonemapping.Entity.ReviewGrade;
import com.example.capstonemapping.Repository.ProjectRepository;
import com.example.capstonemapping.Repository.RequestRepository;
import com.example.capstonemapping.Repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/supervisors")
public class SupervisorController {
    @Autowired
    SupervisorRepository supervisorRepository;
    @Autowired
    RequestRepository requestRepository;

    @Autowired
    ProjectRepository projectRepository;
    @GetMapping(path = "/{id}/requests")
    public @ResponseBody List<Request> getRequests(@PathVariable String id){
        List<Request> requests = requestRepository.findBySupervisorAndRequestStatus(supervisorRepository.findById(id).get(), RequestStatus.REQUESTED);
        return requests;
    }


}
