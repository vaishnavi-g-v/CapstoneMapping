package com.example.capstonemapping.Controller;

import com.example.capstonemapping.Entity.Request;
import com.example.capstonemapping.Entity.RequestStatus;
import com.example.capstonemapping.Repository.RequestRepository;
import com.example.capstonemapping.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.capstonemapping.Model.RequestModel;
@Controller
@RequestMapping(path = "/requests")
public class RequestController {

    @Autowired
    RequestRepository requestRepository;
    @Autowired
    RequestService requestService;
    @PostMapping(path = "/")
    public @ResponseBody Request newRequest(@RequestBody RequestModel request) {
//        return requestRepository.save(request);
        return requestService.saveRequest(request);
    }

    @PatchMapping(path = "/requests/{rid}")
    public @ResponseBody Request patchRequest(@RequestParam boolean accept, @PathVariable int rid){
        Request r = requestRepository.findById(rid).get();
        if(accept){
            r.setRequestStatus(RequestStatus.ACCEPTED);
        } else {
            r.setRequestStatus(RequestStatus.REJECTED);
        }
        r = requestRepository.save(r);
        return r;
    }
}
