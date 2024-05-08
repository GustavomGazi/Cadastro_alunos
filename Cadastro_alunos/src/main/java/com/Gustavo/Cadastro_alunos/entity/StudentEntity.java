package com.Gustavo.Cadastro_alunos.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table
public class StudentEntity {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    private String name;


    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dataOfBirth;

    private String email;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String name, LocalDate dataOfBirth, String email) {
        this.id = id;
        this.name = name;
        this.dataOfBirth = dataOfBirth;
        this.email = email;
    }

    public StudentEntity(String name, LocalDate dataOfBirth, String email) {
        this.name = name;
        this.dataOfBirth = dataOfBirth;
        this.email = email;
    }

    public StudentEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public StudentEntity(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(LocalDate dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}