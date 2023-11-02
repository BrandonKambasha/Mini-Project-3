package com.MiniProject.Students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MiniProject.Students.model.student;
import com.MiniProject.Students.repository.StudentRepo;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepo studentRepository;

    @PostMapping
    public student createStudent(@RequestBody student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PutMapping("/{id}")
    public student updateStudent(@PathVariable Long id, @RequestBody student student) {
        student.setId(id); // Set the ID from the path variable
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
