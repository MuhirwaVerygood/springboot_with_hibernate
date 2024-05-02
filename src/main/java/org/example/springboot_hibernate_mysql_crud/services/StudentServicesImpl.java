package org.example.springboot_hibernate_mysql_crud.services;

import jakarta.transaction.Transactional;
import org.example.springboot_hibernate_mysql_crud.dao.StudentDao;
import org.example.springboot_hibernate_mysql_crud.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicesImpl implements StudentsService{
    @Autowired
    private   StudentDao studentDao;

    @Override
    @Transactional
    public ResponseEntity<List<Students>> getStudents() {
        return studentDao.getStudents();
    }

    @Transactional
    @Override
    public ResponseEntity<Object> save(Students student) {
        return studentDao.save(student);
    }

    @Transactional
    @Override
    public ResponseEntity<String> delete(Long id) {
       return studentDao.delete(id);
    }

    @Transactional
    @Override
    public ResponseEntity<Object> update(Long id, Students student) {
       return studentDao.update(id, student);
    }
}
