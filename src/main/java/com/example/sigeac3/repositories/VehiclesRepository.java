package com.example.sigeac3.repositories;

import com.example.sigeac3.entities.Vehicles;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class VehiclesRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Vehicles vehicle) {
        em.persist(vehicle);
    }
}