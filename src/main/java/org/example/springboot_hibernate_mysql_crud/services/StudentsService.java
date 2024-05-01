package org.example.springboot_hibernate_mysql_crud.services;

import org.example.springboot_hibernate_mysql_crud.models.Students;

import java.util.List;

public interface StudentsService {
    List<Students> getStudents();
    void save(Students student);
    void delete(Long id);
    void update(Long id, Students   student);
}
