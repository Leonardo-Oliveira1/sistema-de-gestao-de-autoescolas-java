package com.example.sigeac3.repository;

import com.example.sigeac3.models.Vehicles;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class VehiclesDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Vehicles vehicle) {
        em.persist(vehicle);
    }
}