package com.libraryApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class UniversityService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Course createCourse(String name, int credits,Long professorId){

        Professor professor = em.find(Professor.class,professorId);

        if (professor != null) {
            Course newCourse = new Course(name, credits);
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
}
