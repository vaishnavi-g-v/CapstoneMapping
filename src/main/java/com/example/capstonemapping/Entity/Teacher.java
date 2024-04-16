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

    String pswd;

    public Teacher(){}

//    @JsonInclude()
//    @Transient
//    public boolean isSupervisor;
}
