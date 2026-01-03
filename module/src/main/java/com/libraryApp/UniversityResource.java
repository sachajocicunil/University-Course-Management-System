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

    @POST
    @Path("/course")
    @Produces(MediaType.APPLICATION_JSON)
    public void createCourse(Course course){
        universityservice.createCourse(course);
    }






//    @GET
//    @Path("/hello")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String hello() {
//        return "Hello World";
//    }
}
