package com.example.capstonemapping.Repository;

import com.example.capstonemapping.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capstonemapping.Entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByTeam(Team team);
}
