package com.example.sigeac3.models;

import java.time.LocalDateTime;

public class Student extends Person{

    private LocalDateTime maximumDateToComplete;

    public LocalDateTime getMaximumDateToComplete() {
        return maximumDateToComplete;
    }

    public void setMaximumDateToComplete(LocalDateTime maximumDateToComplete) {
        this.maximumDateToComplete = maximumDateToComplete;
    }
}
