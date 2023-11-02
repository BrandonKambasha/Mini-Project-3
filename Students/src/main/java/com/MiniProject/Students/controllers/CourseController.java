package com.MiniProject.Students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MiniProject.Students.model.course;
import com.MiniProject.Students.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public course createCourse(@RequestBody course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping
    public List<course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping("/{id}")
    public course updateCourse(@PathVariable Long id, @RequestBody course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}

