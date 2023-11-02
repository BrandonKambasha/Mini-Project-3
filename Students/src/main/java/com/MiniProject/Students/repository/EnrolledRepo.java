package com.MiniProject.Students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MiniProject.Students.model.Enrolled;

public interface EnrolledRepo extends JpaRepository<Enrolled, Long> {
}

