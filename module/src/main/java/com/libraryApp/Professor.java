package com.libraryApp;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Professor extends User{
private double salary;
private String department;
@OneToMany(mappedBy = "professor")
private List<Course> courses;

    public Professor(String firstName, String lastName, String email, double salary, String department) {
        super(firstName, lastName, email);
        this.salary=salary;
        this.department=department;
    }

    public Professor() {

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getRole(){
        return "PROFESSOR";
    }
}
