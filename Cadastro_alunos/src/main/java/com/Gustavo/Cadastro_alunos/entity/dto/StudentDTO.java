package com.Gustavo.Cadastro_alunos.entity.dto;


import com.Gustavo.Cadastro_alunos.entity.StudentEntity;
import java.time.LocalDate;


public class StudentDTO {

    private String name;

    private String email;

    private LocalDate dateOfBirth;

    public StudentDTO(String name, String email, LocalDate dataOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dataOfBirth;
    }

    public StudentEntity builder(String name, String email, LocalDate dateOfBirth){
        StudentEntity entity = new StudentEntity(name, dateOfBirth, email);
        return entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



}