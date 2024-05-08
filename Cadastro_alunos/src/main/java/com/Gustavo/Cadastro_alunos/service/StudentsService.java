package com.Gustavo.Cadastro_alunos.service;

import com.Gustavo.Cadastro_alunos.entity.StudentEntity;
import com.Gustavo.Cadastro_alunos.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(StudentEntity parametro){
        studentRepository.save(parametro);
        return "salvo com sucesso";
    }

    public Optional<StudentEntity> getStudentById(Long studentId){
        Optional<StudentEntity> student = studentRepository.findById(studentId);
        return student;
    }

    public List<StudentEntity> getStudents(){
        return studentRepository.findAll();
    }

    public void deleteStudentById(Long studentId){
        studentRepository.deleteById(studentId);
    }

    public void createOrUpdateStudent(Long studentId, String name, String email){
        Optional<StudentEntity> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            StudentEntity updated_student = new StudentEntity(studentId, name, email);
            studentRepository.save(updated_student);
        } else {
            StudentEntity new_student = new StudentEntity(name,email);
            studentRepository.save(new_student);
        }

    }
}