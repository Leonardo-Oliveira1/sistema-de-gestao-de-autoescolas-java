package com.example.sigeac3.services;

import com.example.sigeac3.entities.Student;
import com.example.sigeac3.repositories.StudentRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class StudentService {

    @Inject
    private StudentRepository studentRepository;

    public void save(Student student) throws Exception {
        this.validateRequiredFields(student);

        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    private void validateRequiredFields(Student student) throws Exception {
        if(student.getName() == null || student.getName().trim().isEmpty()
                || student.getLastname() == null | student.getLastname().trim().isEmpty()
                || student.getCpf() == null || student.getCpf().trim().isEmpty()
                ||  student.getEmail() == null || student.getEmail().trim().isEmpty()
                || student.getPassword() == null || student.getPassword().trim().isEmpty()
        ){
            throw new Exception("Por favor, preencha todos os campos");
        }
    }

}
