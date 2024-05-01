package org.example.springboot_hibernate_mysql_crud.controllers;

import org.example.springboot_hibernate_mysql_crud.models.Students;
import org.example.springboot_hibernate_mysql_crud.services.StudentServicesImpl;
import org.example.springboot_hibernate_mysql_crud.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentControllersImpl  implements StudentControllers{
    @Autowired
    private StudentsService studentsService;

    @GetMapping
    @Override
    public List<Students> getStudents() {
        return studentsService.getStudents();
    }

    @PostMapping
    @Override
    public void save( @RequestBody Students student) {
        studentsService.save(student);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void delete(@PathVariable("id") Long id) {
        studentsService.delete(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public void update( @PathVariable("id") Long id, @RequestBody Students students) {
        studentsService.update(id, students);
    }
}
