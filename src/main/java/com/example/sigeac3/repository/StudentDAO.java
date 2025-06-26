package com.example.sigeac3.repository;

import com.example.sigeac3.models.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class StudentDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Student student) {
        em.persist(student);
    }

    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

}
