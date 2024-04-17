package com.example.capstonemapping.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Teacher {
    @Id
    String teacher_id;
    @NonNull
    String Fname;
    @NonNull
    String Lname;

    String email;

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPswd() {
        return pswd;
    }

    String pswd;

    public Teacher(){}

//    @JsonInclude()
//    @Transient
//    public boolean isSupervisor;
}
