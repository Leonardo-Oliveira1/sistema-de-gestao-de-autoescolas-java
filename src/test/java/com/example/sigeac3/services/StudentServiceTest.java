package com.example.sigeac3.services;

import com.example.sigeac3.entities.Student;
import com.example.sigeac3.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    private Student student;

    @BeforeEach
    void setup() {
        student = new Student();
        student.setName("Leonardo");
        student.setLastname("Silva");
        student.setCpf("12345678900");
        student.setEmail("leo@email.com");
        student.setPassword("senhaSegura");
    }

    @Test
    @DisplayName("Deve salvar aluno quando todos os campos obrigatórios estiverem preenchidos")
    void saveWithValidData() throws Exception {
        studentService.save(student);

        verify(studentRepository, times(1)).save(student);
    }

    @Test
    @DisplayName("Deve lançar exceção quando campos obrigatórios estiverem vazios")
    void saveWithBlankFieldsThrowsException() {
        student.setName("");
        student.setLastname("");
        student.setCpf("");
        student.setEmail("");
        student.setPassword("");

        Exception ex = assertThrows(Exception.class, () -> studentService.save(student));
        assertEquals("Por favor, preencha todos os campos", ex.getMessage());

        verify(studentRepository, never()).save(any());
    }

    @Test
    @DisplayName("Deve retornar lista de alunos")
    void shouldReturnAllStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(student));

        List<Student> result = studentService.findAll();

        assertEquals(1, result.size());
        assertEquals("Leonardo", result.get(0).getName());
        verify(studentRepository, times(1)).findAll();
    }
}