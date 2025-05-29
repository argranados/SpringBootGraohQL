package com.graphql.example.persistance;

import com.graphql.example.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentDAO extends CrudRepository<Student, Long> {
}
