package com.example.sigeac3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Student extends Person implements Serializable {

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private String status;

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
