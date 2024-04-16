package com.example.capstonemapping.Repository;

import com.example.capstonemapping.Entity.Request;
import com.example.capstonemapping.Entity.RequestStatus;
import com.example.capstonemapping.Entity.Supervisor;
import com.example.capstonemapping.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {
    List<Request> findBySupervisorAndRequestStatus(Supervisor supervisor, RequestStatus status);
    List<Request> findByTeam(Team team);
}
