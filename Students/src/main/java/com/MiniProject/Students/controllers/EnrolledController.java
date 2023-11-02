package com.MiniProject.Students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MiniProject.Students.model.Enrolled;
import com.MiniProject.Students.service.EnrolledService;

import java.util.List;

@RestController
@RequestMapping("/enrolled")
public class EnrolledController {
    private final EnrolledService enrolledService;

    @Autowired
    public EnrolledController(EnrolledService enrolledService) {
        this.enrolledService = enrolledService;
    }

    @PostMapping
    public Enrolled createEnrolled(@RequestBody Enrolled enrolled) {
        return enrolledService.createEnrolled(enrolled);
    }

    @GetMapping("/{id}")
    public Enrolled getEnrolledById(@PathVariable Long id) {
        return enrolledService.getEnrolledById(id);
    }

    @GetMapping
    public List<Enrolled> getAllEnrolled() {
        return enrolledService.getAllEnrolled();
    }

    @PutMapping("/{id}")
    public Enrolled updateEnrolled(@PathVariable Long id, @RequestBody Enrolled enrolled) {
        return enrolledService.updateEnrolled(id, enrolled);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrolled(@PathVariable Long id) {
        enrolledService.deleteEnrolled(id);
    }
}

