package com.example.capstonemapping.Repository;

import com.example.capstonemapping.Entity.Project;
import com.example.capstonemapping.Entity.Supervisor;
import com.example.capstonemapping.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findByTeam(Team team);
    List<Project> findBySupervisor(Supervisor supervisor);
}
