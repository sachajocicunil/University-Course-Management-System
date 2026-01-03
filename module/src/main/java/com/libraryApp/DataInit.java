package com.libraryApp;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Singleton
@Startup
public class DataInit {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        // Create Professors
        Professor prof1 = new Professor("John", "Doe", "john.doe@university.com", 5000.0, "Computer Science");
        Professor prof2 = new Professor("Jane", "Smith", "jane.smith@university.com", 5500.0, "Mathematics");

        em.persist(prof1);
        em.persist(prof2);

        // Create Students
        Student student1 = new Student("Alice", "Brown", "alice.brown@student.com", "S1001", 0);
        Student student2 = new Student("Bob", "White", "bob.white@student.com", "S1002", 10);

        em.persist(student1);
        em.persist(student2);

        // Create Courses
        Course course1 = new Course("Intro to Java", 4);
        course1.setProfessor(prof1);
        
        Course course2 = new Course("Advanced Calculus", 3);
        course2.setProfessor(prof2);

        Course course3 = new Course("Web Development", 5);
        course3.setProfessor(prof1);

        em.persist(course1);
        em.persist(course2);
        em.persist(course3);
    }
}
