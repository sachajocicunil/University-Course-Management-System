package com.libraryApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    public void testStudentCreation() {
        // Instanciation d'un étudiant
        Student student = new Student("Alice", "Brown", "alice.brown@student.com", "S1001", 0);

        // Vérification que getRole() retourne bien "STUDENT"
        assertEquals("STUDENT", student.getRole());
    }
}
