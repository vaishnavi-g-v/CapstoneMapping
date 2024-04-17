package com.example.capstonemapping.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    private String srn;
    private Integer semester;
    private Float cgpa;
    private String FName;
    private String Lname;

    private String email;
    private String pswd;
    private Integer outgoing_year;
    @ManyToOne()//cascade = CascadeType.ALL)
//    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;

    public String getPswd() {
        return pswd;
    }

    public Integer getOutgoing_year() {
        return outgoing_year;
    }

    public void setOutgoing_year(Integer outgoing_year) {
        this.outgoing_year = outgoing_year;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer genSemester(){
        int sem = 6;
        /*
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        sem = 4 - (this.outgoing_year - year);
        */

        return sem;
    }

    @Override
    public String toString(){
        return "Student{" +
                "srn=" + this.srn +
                ", name=" + this.FName + " " + this.Lname +
                ", semester=" + this.semester+
                ", cgpa=" + this.cgpa +
                ", email=" + this.email +
                ", outgoing year=" + this.outgoing_year +
                "}";
    }

    public boolean teamEligibility(){
        if(semester < 5) return false;
        return true;
    }

    public boolean hasTeam(){
        if(team==null) return false;
        return true;
    }
}
