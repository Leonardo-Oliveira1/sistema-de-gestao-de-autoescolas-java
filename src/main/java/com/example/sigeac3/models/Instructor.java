package com.example.sigeac3.models;

public class Instructor extends Person{
    private Integer weekly_workload_hours;
    private Double hourly_salary;

    public Integer getWeekly_workload_hours() {
        return weekly_workload_hours;
    }

    public void setWeekly_workload_hours(Integer weekly_workload_hours) {
        this.weekly_workload_hours = weekly_workload_hours;
    }

    public Double getHourly_salary() {
        return hourly_salary;
    }

    public void setHourly_salary(Double hourly_salary) {
        this.hourly_salary = hourly_salary;
    }
}
