package com.learning.service;

import com.learning.model.Instructor;
import com.learning.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;


    public ResponseEntity<?> add(Instructor instructor) {
        instructor.setRole("INSTRUCTOR");
        instructor.setStatus(true);
        return new ResponseEntity<>(instructorRepository.save(instructor), HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(Instructor instructor) {
        if (!isExist(instructor.getId()))
            return new ResponseEntity<>("There Are No Instructor With id = " + instructor.getId(),
                    HttpStatus.NOT_FOUND);
        instructor.setRole("INSTRUCTOR");
        return new ResponseEntity<>(instructorRepository.save(instructor), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(instructorRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getCoursesForInstructor(int instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
        if (instructor == null)
            return new ResponseEntity<>("There Are No Instructor With id = " + instructor.getId(),
                    HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(instructor.getCourses(), HttpStatus.ACCEPTED);

    }

    public ResponseEntity<?> deleteById(int instructorId) {
        if (!isExist(instructorId))
            return new ResponseEntity<>("There Are No Instructor With id = " + instructorId, HttpStatus.NOT_FOUND);
        instructorRepository.deleteById(instructorId);
        return new ResponseEntity<>("Deleted Success...", HttpStatus.ACCEPTED);

    }

    public Instructor getById(int instructorId) {
        return instructorRepository.findById(instructorId).orElse(null);
    }

    private boolean isExist(int instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
        return (instructor == null) ? false : true;
    }
}
