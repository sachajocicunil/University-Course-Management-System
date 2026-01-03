package com.libraryApp;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Student extends User{
    private String studentId;
    private int credits;

    Student(String firstName,String lastName, String email,String studentId, int credits){
        super(firstName,email,lastName);
        this.studentId = studentId;
        this.credits= credits;

    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Student() {

    }

    public String getRole(){
        return "STUDENT";
    }


}
