package com.libraryApp;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/school")
public class UniversityResource {


    @Inject
    private UniversityService universityservice;


    @GET
    @Path("/students/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("id") Long id){
        return universityservice.getStudent(id);
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public java.util.List<Student> getAllStudents(){
        return universityservice.getAllStudents();
    }

    @PUT
    @Path("/students/{id}/credits")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudentCredits(@PathParam("id") Long id, Integer credits){
        return universityservice.updateStudentCredits(id, credits);
    }

    @POST
    @Path("/course")
    @Produces(MediaType.APPLICATION_JSON)
    public void createCourse(Course course){
        universityservice.createCourse(course);
    }

   







    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World";
    }
}
