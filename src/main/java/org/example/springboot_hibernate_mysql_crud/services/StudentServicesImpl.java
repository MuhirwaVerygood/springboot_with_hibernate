package org.example.springboot_hibernate_mysql_crud.services;

import jakarta.transaction.Transactional;
import org.example.springboot_hibernate_mysql_crud.dao.StudentDao;
import org.example.springboot_hibernate_mysql_crud.dao.StudentDaoImpl;
import org.example.springboot_hibernate_mysql_crud.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicesImpl implements StudentsService{
    @Autowired
    private   StudentDao studentDao;

    @Override
    @Transactional
    public List<Students> getStudents() {
        return studentDao.getStudents();
    }

    @Transactional
    @Override
    public void save(Students student) {
        studentDao.save(student);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        studentDao.delete(id);
    }

    @Transactional
    @Override
    public void update(Long id, Students student) {
        studentDao.update(id, student);
    }
}
