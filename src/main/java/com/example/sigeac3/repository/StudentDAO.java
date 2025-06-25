package com.example.sigeac3.repository;

import com.example.sigeac3.models.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class StudentDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Student student) {
        em.persist(student);
    }
}
