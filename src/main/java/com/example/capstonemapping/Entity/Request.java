package com.example.capstonemapping.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int requestID;

    @ManyToOne()
    Team team;

    @ManyToOne()
    Supervisor supervisor;

    String interestedDomain;

    String idea;

    @Enumerated(EnumType.ORDINAL)
    RequestStatus requestStatus;

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

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

    public String getInterestedDomain() {
        return interestedDomain;
    }

    public void setInterestedDomain(String interestedDomain) {
        this.interestedDomain = interestedDomain;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Request(){}
}
