package org.example.springboot_hibernate_mysql_crud.dao;

import org.example.springboot_hibernate_mysql_crud.models.Students;
import org.example.springboot_hibernate_mysql_crud.utils.HibernateUtil;
import org.hibernate.FetchNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.HashMap;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    static SessionFactory  sessionFactory = HibernateUtil.getSessionFactory();
    static Session session = sessionFactory.openSession();
    @Override
    public ResponseEntity<List<Students>> getStudents() {
        session.beginTransaction();
        Query query = session.createQuery("from Students");
        List<Students> students= query.getResultList();
        session.getTransaction().commit();
        return new ResponseEntity<>(students, HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Object> save(Students student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        HashMap<String, Object> response = new HashMap<>();
        response.put("message","User added successfully");
        response.put("student", student);
        return new ResponseEntity<>( response, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<String> delete(Long id) {
 session.beginTransaction();
 Students student = session.get(Students.class, id);
 if(student ==null){
     return new ResponseEntity<>("The student with that id not found", HttpStatusCode.valueOf(404));
 }else{
     session.delete(student);
     session.getTransaction().commit();
     return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
 }
    }


    @Override
    public ResponseEntity<Object> update(Long id, Students student) {
        session.beginTransaction();
        Students stud = session.get(Students.class, id);
        HashMap<String, Object> response = new HashMap<>();
        if(stud != null){
            stud.setFirstname(student.getFirstname());
            stud.setLastname(student.getLastname());
            stud.setEmail(student.getEmail());
            stud.setDob(student.getDob());
            session.update(stud);
            session.getTransaction().commit();
            response.put("message","User udpated successfully");
            response.put("student", student);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("The student with that id not found", HttpStatusCode.valueOf(404));
        }
    }
}
