package org.example.springboot_hibernate_mysql_crud.services;

import org.example.springboot_hibernate_mysql_crud.models.Students;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentsService {
    ResponseEntity<List<Students>> getStudents();

    ResponseEntity<Object> save(Students student);

    ResponseEntity<String> delete(Long id);

    ResponseEntity<Object> update(Long id, Students students);
}