package com.example.sigeac3.controllers;

import com.example.sigeac3.models.Student;
import com.example.sigeac3.repository.StudentDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDateTime;

@Named
@RequestScoped
public class StudentBean {

    private Student student = new Student();

    @Inject
    private StudentDAO studentDAO;

    public void save() {
        try {
            student.setRegistrationDate(LocalDateTime.now());
            student.setStatus("ATIVO");
            studentDAO.save(student);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Aluno cadastrado com sucesso."));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
            e.printStackTrace();
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}