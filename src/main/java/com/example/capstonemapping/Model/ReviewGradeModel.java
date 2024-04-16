package com.example.capstonemapping.Model;

import com.example.capstonemapping.Entity.CapstonePhase;

public class ReviewGradeModel {
    int projectId;
    CapstonePhase phase;

    public CapstonePhase getPhase() {
        return phase;
    }

    public void setPhase(CapstonePhase phase) {
        this.phase = phase;
    }

    String[] teacherIds;

    public ReviewGradeModel(){}

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String[] getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(String[] teacherIds) {
        this.teacherIds = teacherIds;
    }
}
