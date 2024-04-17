package com.example.capstonemapping.Model;

public class TeamFormModel {
    String srn1;
    String srn2;
    String srn3;
    String srn4;

    String teamName;

    TeamFormModel(){};

    public String getSrn1() {
        return srn1;
    }

    public void setSrn1(String srn1) {
        this.srn1 = srn1;
    }

    public String getSrn2() {
        return srn2;
    }

    public void setSrn2(String srn2) {
        this.srn2 = srn2;
    }

    public String getSrn3() {
        return srn3;
    }

    public void setSrn3(String srn3) {
        this.srn3 = srn3;
    }

    public String getSrn4() {
        return srn4;
    }

    public void setSrn4(String srn4) {
        this.srn4 = srn4;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String name) {
        this.teamName = name;
    }
}
