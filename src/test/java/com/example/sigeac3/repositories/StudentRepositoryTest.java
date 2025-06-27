package com.example.sigeac3.repositories;

import com.example.sigeac3.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

class StudentRepositoryTest {

    private static EntityManagerFactory emf;
    private EntityManager em;

    @BeforeAll
    static void init() {
        // Inicializa o EntityManagerFactory com a unidade de persistência de teste
        emf = Persistence.createEntityManagerFactory("h2db");
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    @AfterAll
    static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    @Test
    void findAll() {
    }
}