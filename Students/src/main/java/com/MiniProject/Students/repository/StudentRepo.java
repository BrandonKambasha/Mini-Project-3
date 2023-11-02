package com.MiniProject.Students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MiniProject.Students.model.student;

public interface StudentRepo extends JpaRepository<student, Long> {
}
