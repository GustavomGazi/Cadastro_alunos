package com.Gustavo.Cadastro_alunos.controler;

import com.Gustavo.Cadastro_alunos.entity.StudentEntity;
import com.Gustavo.Cadastro_alunos.entity.dto.StudentDTO;
import com.Gustavo.Cadastro_alunos.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping()
    public List<StudentEntity> getStudents() {
        return studentsService.getStudents();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Object> getStudentById(@PathVariable(value = "studentId") Long studentId) {
        Optional<StudentEntity> entity = studentsService.getStudentById(studentId);
        if(entity.isPresent()) {
            StudentDTO studentDTO = new StudentDTO(entity.get().getName(), entity.get().getEmail(), entity.get().getDataOfBirth());
            return ResponseEntity.status(HttpStatus.OK).body(studentDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }

    @PostMapping
    public String saveStudent(@RequestBody StudentDTO studentDTO) {
        StudentEntity studentEntity = studentDTO.builder(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getDateOfBirth());
        return studentsService.saveStudent(studentEntity);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable(value = "studentId") Long studentId){
        studentsService.deleteStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public void updateOrCreateStudent(@PathVariable(value = "studentId") Long studentId,
                                      @RequestParam String email, @RequestParam String name) {

        studentsService.createOrUpdateStudent(studentId, email, name);

    }

}