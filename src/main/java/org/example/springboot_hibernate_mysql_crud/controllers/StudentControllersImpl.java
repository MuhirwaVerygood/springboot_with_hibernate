package org.example.springboot_hibernate_mysql_crud.controllers;

import org.example.springboot_hibernate_mysql_crud.models.Students;
import org.example.springboot_hibernate_mysql_crud.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentControllersImpl  implements StudentControllers{
    @Autowired
    private StudentsService studentsService;

    @GetMapping
    @Override
    public ResponseEntity<List<Students>> getStudents() {
        return studentsService.getStudents();
    }

    @PostMapping
    @Override
    public ResponseEntity<Object> save(@RequestBody Students student) {
     return  studentsService.save(student);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
      return  studentsService.delete(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Students students) {
      return   studentsService.update(id, students);
    }
}
