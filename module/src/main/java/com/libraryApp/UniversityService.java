package com.libraryApp;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UniversityService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Course createCourse(Course course){

        Professor professor = em.find(Professor.class,course.getProfessor());

        if (professor != null) {
            Course newCourse = new Course(course.getName(), course.getCredits());
            newCourse.setProfessor(professor);
            em.persist(newCourse);
            return newCourse;
        }
    return null;
    }

    @Transactional
    public Student updateStudentCredits(Long studentId, int newCredits){
        Student student = em.find(Student.class,studentId);
        if (student!=null) {
            student.setCredits(newCredits);
            return student;
        }
        return null;
    }

    @Transactional
    public Student getStudent(Long studentId){
        Student student = em.find(Student.class,studentId);
        if (student!=null) {
            return student;
        }
        return null;
    }
}
