package org.example.springboot_hibernate_mysql_crud.dao;

import org.example.springboot_hibernate_mysql_crud.models.Students;
import org.example.springboot_hibernate_mysql_crud.utils.HibernateUtil;
import org.hibernate.FetchNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    static SessionFactory  sessionFactory = HibernateUtil.getSessionFactory();
    static Session session = sessionFactory.openSession();
    @Override
    public List<Students> getStudents() {
        session.beginTransaction();
        Query query = session.createQuery("from Students");
        List<Students> students= query.getResultList();
        session.getTransaction().commit();
        return students;
    }

    @Override
    public void save(Students student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    @DeleteMapping
    @Override
    public void delete(Long id) {
 session.beginTransaction();
 Students student = session.get(Students.class, id);
 if(student != null){
     session.delete( id);
     System.out.println("Student deleted successfully");
     session.getTransaction().commit();
 }else{
     throw  new FetchNotFoundException("The student with that id does not exist", id);
 }
    }


    @Override
    public void update(Long id, Students student) {
        session.beginTransaction();
        Students stud = session.get(Students.class, id);
        if(stud != null){
            stud.setFirstname(student.getFirstname());
            stud.setLastname(student.getLastname());
            stud.setEmail(student.getEmail());
            stud.setDob(student.getDob());
            session.update(stud);
            session.getTransaction().commit();
            System.out.println("Student updated successfully");
        }

    }
}
