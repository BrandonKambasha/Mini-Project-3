package com.MiniProject.Students.service;

import org.springframework.stereotype.Service;

import com.MiniProject.Students.model.student;
import com.MiniProject.Students.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo studentRepository;

    @Autowired
    public StudentService(StudentRepo studentRepository) {
        this.studentRepository = studentRepository;
    }

    public student createStudent(student student) {
        return studentRepository.save(student);
    }

    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }

    public student getStudentById(Long id) {
        Optional<student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    public student updateStudent(Long id, student updatedStudent) {
        Optional<student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            student existingStudent = optionalStudent.get();
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setAge(updatedStudent.getAge());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

