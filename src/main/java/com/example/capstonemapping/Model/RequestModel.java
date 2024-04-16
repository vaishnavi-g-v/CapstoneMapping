package com.example.capstonemapping.Model;

public class RequestModel {
    int teamID;
    String teacherID;
    String idea;
    String interestedDomain;

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getInterestedDomain() {
        return interestedDomain;
    }

    public void setInterestedDomain(String interestedDomain) {
        this.interestedDomain = interestedDomain;
    }

    RequestModel(){};


}


//{
//        "team": {"teamId":1},
//        "supervisor": {"teacher_id":"T123456789000"},
//        "idea": "LLM",
//        "interested_domain": "Data Analytics"
//        }