package com.example.sigeac3.controllers;

import com.example.sigeac3.models.Student;
import com.example.sigeac3.repository.StudentDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.util.List;

@Named
@RequestScoped
public class StudentBean {

    private Student student = new Student();

    @Inject
    private StudentDAO studentDAO;

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = studentDAO.findAll();
    }

    public List<Student> getStudents() {
        return students;
    }


    public void save() {
        try {
            student.setRegistrationDate(LocalDateTime.now());
            student.setStatus("ATIVO");

            if(student.getName() == null || student.getName().trim().isEmpty()
                    || student.getLastname() == null | student.getLastname().trim().isEmpty()
                    || student.getCpf() == null || student.getCpf().trim().isEmpty()
                    ||  student.getEmail() == null || student.getEmail().trim().isEmpty()
                    || student.getPassword() == null || student.getPassword().trim().isEmpty()
            ){
                throw new Exception("Por favor, preencha todos os campos");
            }

            studentDAO.save(student);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso:", "Aluno cadastrado com sucesso."));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", e.getMessage()));
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