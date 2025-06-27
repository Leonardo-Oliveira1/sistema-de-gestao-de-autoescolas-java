package com.example.sigeac3.controllers;

import com.example.sigeac3.entities.Student;
import com.example.sigeac3.repositories.StudentRepository;
import com.example.sigeac3.services.StudentService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.util.List;

@Named
@ApplicationScoped
public class StudentBean {

    @Inject
    private StudentRepository studentRepository;

    @Inject
    private StudentService studentService;

    @PostConstruct
    public void init() {
        students = studentService.findAll();
    }

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    private Student student = new Student();

    public void save() {
        try {
            student.setRegistrationDate(LocalDateTime.now());
            student.setStatus("ATIVO");
            studentService.save(student);

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