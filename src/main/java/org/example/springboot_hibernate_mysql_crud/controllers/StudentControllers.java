package org.example.springboot_hibernate_mysql_crud.controllers;

import org.example.springboot_hibernate_mysql_crud.models.Students;

import java.util.List;

public interface StudentControllers {
    List<Students> getStudents();
    void save(Students student);
    void delete(Long id);
    void update(Long id, Students students);
}
