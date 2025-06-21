package com.example.sigeac3.controllers;

import com.example.sigeac3.models.Student;
import com.example.sigeac3.models.Vehicles;
import com.example.sigeac3.repository.VehiclesDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class StudentController {

    @Inject
    private VehiclesDAO vehiclesDAO;

    Student student = new Student();

    public String showStudentInfo() {
        student.setEmail("test@provider.com");

        return student.getEmail();
    }

    public void test() {
        System.out.println("chegou1");
        Vehicles vehicle = new Vehicles();
        vehicle.setBrand("Teste");
        vehicle.setModel("TesteModel");
        vehicle.setLicensePlate("XYZ-9876");
        System.out.println("chegou2");

        vehiclesDAO.save(vehicle);
        System.out.println("chegou3");

    }
}