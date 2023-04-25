package com.learning.service;

import com.learning.model.Instructor;
import com.learning.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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
        checkIfInstructorIsExistOrThrowException(instructor.getId());
        instructor.setRole("INSTRUCTOR");
        return new ResponseEntity<>(instructorRepository.save(instructor), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(instructorRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getCoursesForInstructor(int instructorId) {
        Instructor instructor = getById(instructorId);
        return new ResponseEntity<>(instructor.getCourses(), HttpStatus.ACCEPTED);

    }

    public ResponseEntity<?> deleteById(int instructorId) {

        checkIfInstructorIsExistOrThrowException(instructorId);
        instructorRepository.deleteById(instructorId);
        return new ResponseEntity<>("Deleted Success...", HttpStatus.ACCEPTED);

    }

    public Instructor getById(int instructorId) {

        return instructorRepository.findById(instructorId).orElseThrow(() ->
                new NoSuchElementException("There Are No Instructor With id = " + instructorId));
    }

    private void checkIfInstructorIsExistOrThrowException(int instructorId) {
        getById(instructorId);
    }
}
