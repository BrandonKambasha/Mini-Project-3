package com.MiniProject.Students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiniProject.Students.model.course;
import com.MiniProject.Students.repository.CourseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepo courseRepository;

    @Autowired
    public CourseService(CourseRepo courseRepository) {
        this.courseRepository = courseRepository;
    }

    public course createCourse(course course) {
        return courseRepository.save(course);
    }

    public List<course> getAllCourses() { 
        return courseRepository.findAll();
    }

    public course getCourseById(Long id) {
        Optional<course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.orElse(null);
    }

    public course updateCourse(Long id, course updatedCourse) {
        Optional<course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            course existingCourse = optionalCourse.get();
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setCourseCode(updatedCourse.getCourseCode());
            return courseRepository.save(existingCourse);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

