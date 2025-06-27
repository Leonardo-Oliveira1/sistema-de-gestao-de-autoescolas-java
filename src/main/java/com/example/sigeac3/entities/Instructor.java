package com.example.sigeac3.entities;

import jakarta.persistence.*;

@Entity
public class Instructor extends Person{

    @Column(nullable = false)
    private String allowedCategories;

    @Column(nullable = false)
    private String status;

    public String getAllowedCategories() {
        return allowedCategories;
    }

    public void setAllowedCategories(String allowedCategories) {
        this.allowedCategories = allowedCategories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
