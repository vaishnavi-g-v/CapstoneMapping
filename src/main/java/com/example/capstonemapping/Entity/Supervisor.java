package com.example.capstonemapping.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;



@Entity
@Data
public class Supervisor extends Teacher {
    int teamLimit;
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "supervisor_years", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "year", nullable = false)
    private List<Integer> years = new ArrayList<>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "supervisor_domains", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "domain", nullable = false)
    private List<String> domains = new ArrayList<>();

    public Supervisor(){}
}
