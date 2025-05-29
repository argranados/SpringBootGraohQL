package com.graphql.example.persistance;

import com.graphql.example.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICursoDAO extends CrudRepository<Course, Long> {
}
