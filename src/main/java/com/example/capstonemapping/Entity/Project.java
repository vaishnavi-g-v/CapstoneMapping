package com.example.capstonemapping.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int projectID;

    @OneToOne()
    Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    @ManyToOne()
    Supervisor supervisor;

    @Column(columnDefinition = "DATE", nullable = false, updatable = false)
    @CreationTimestamp
    Date startDate;

    @Column(columnDefinition = "DATE")
    Date endDate;

    @Enumerated(EnumType.ORDINAL)
    CapstonePhase phase;

    String domain;

    String problemStatement;

    public Date getStartDate() {
        return startDate;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public CapstonePhase getPhase() {
        return phase;
    }

    public void setPhase(CapstonePhase phase) {
        this.phase = phase;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }


    public Project(){}
}
