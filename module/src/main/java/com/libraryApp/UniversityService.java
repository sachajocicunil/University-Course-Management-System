package com.libraryApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@PersistenceContext
public class UniversityService {
    private EntityManager em;

    @Transactional
    public Course createCourse(String name, int credits,Long professorId){
        Professor professor = em.find(Professor.class,professorId);
        Course newCourse = new Course(name,credits);
        List<Course> profCourseList = professor.getCourses();
        profCourseList.add(newCourse);
        professor.setCourses(profCourseList);
        em.persist(newCourse);
        return newCourse;
    }

    @Transactional
    public Student updateStudentCredits(Long studentId, int newCredits){
        Student student = em.find(Student.class,studentId);
        student.setCredits(newCredits);
        return student;
    }
}
