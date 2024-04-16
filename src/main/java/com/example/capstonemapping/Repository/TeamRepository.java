package com.example.capstonemapping.Repository;

import com.example.capstonemapping.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
