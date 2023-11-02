package com.MiniProject.Students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MiniProject.Students.model.course;

public interface CourseRepo extends JpaRepository<course, Long> {
}
