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
    public Course createCourse(Course course) {
        // 1. Vérification de sécurité pour éviter le NullPointerException
        if (course.getProfessor() == null) {
            return null; // ou lancer une exception
        }

        // 2. CORRECTION : On récupère l'ID (.getId()) pour chercher en base
        Professor professor = em.find(Professor.class, course.getProfessor().getId());

        if (professor != null) {
            // Note : Pas besoin de recréer un "new Course" si l'objet 'course' en paramètre est déjà propre.
            // Mais pour être sûr de n'avoir que les données voulues, ta méthode est acceptable.
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


    public Student getStudent(Long studentId){
        Student student = em.find(Student.class,studentId);
        if (student!=null) {
            return student;
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }
}
