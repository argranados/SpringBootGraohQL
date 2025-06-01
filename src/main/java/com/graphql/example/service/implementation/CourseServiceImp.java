package com.graphql.example.service.implementation;

import com.graphql.example.entities.Course;
import com.graphql.example.persistance.ICursoDAO;
import com.graphql.example.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImp implements ICourseService {

    @Autowired
    ICursoDAO cursoDAO;

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return cursoDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) cursoDAO.findAll();
    }

    @Override
    @Transactional
    public void createCourse(Course course) {
        cursoDAO.save(course);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cursoDAO.deleteById(id);
    }
}
