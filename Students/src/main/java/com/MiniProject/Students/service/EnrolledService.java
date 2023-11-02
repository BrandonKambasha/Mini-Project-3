package com.MiniProject.Students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiniProject.Students.model.Enrolled;
import com.MiniProject.Students.repository.EnrolledRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EnrolledService {
    private final EnrolledRepo enrolledRepository;

    @Autowired
    public EnrolledService(EnrolledRepo enrolledRepository) {
        this.enrolledRepository = enrolledRepository;
    }

    public Enrolled createEnrolled(Enrolled enrolled) {
        return enrolledRepository.save(enrolled);
    }

    public List<Enrolled> getAllEnrolled() {
        return enrolledRepository.findAll();
    }

    public Enrolled getEnrolledById(Long id) {
        Optional<Enrolled> optionalEnrolled = enrolledRepository.findById(id);
        return optionalEnrolled.orElse(null);
    }
 
    public Enrolled updateEnrolled(Long id, Enrolled updatedEnrolled) {
        Optional<Enrolled> optionalEnrolled = enrolledRepository.findById(id);
        if (optionalEnrolled.isPresent()) {
            Enrolled existingEnrolled = optionalEnrolled.get();
            // Update any properties as needed
            return enrolledRepository.save(existingEnrolled);
        }
        return null;
    }

    public void deleteEnrolled(Long id) {
        enrolledRepository.deleteById(id);
    }
}
