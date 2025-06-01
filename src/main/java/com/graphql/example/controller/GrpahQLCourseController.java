package com.graphql.example.controller;

import com.graphql.example.entities.Course;
import com.graphql.example.grpahql.InputCourse;
import com.graphql.example.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GrpahQLCourseController {
    @Autowired
    ICourseService courseService;

    @QueryMapping
    public Course findCourseById(@Argument(name ="courseId") String id) {
        Long courseId = Long.parseLong(id);

        return courseService.findById(courseId);
    }

    @QueryMapping(name = "findAllCourses")
    public List<Course> findAll () {
        return courseService.findAll();
    }

    @MutationMapping
    public Course createCourse(@Argument(name = "inputCourse") InputCourse inputCourse) {
        Course course = new Course();
        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());

        courseService.createCourse(course);

        return course;
    }

    @MutationMapping(name = "deleteCourseById")
    public String deleteById(@Argument(name = "courseId") String id) {
        Long courseId = Long.parseLong(id);
        courseService.deleteById(courseId);

        return "El curso ha sido borrado " + id;
    }

}
