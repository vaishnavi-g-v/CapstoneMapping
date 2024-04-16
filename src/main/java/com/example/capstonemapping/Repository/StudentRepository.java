package com.example.capstonemapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capstonemapping.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
