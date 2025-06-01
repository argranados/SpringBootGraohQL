package com.graphql.example.grpahql;

import lombok.Data;

@Data
public class InputStudent {

    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String courseId;
}
