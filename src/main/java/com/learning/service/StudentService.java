package com.learning.service;

import com.learning.model.Student;
import com.learning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<?> register(Student student) {
        student.setRole("STUDENT");
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(Student student) {
        checkIfStudentIsExistOrThrowException(student.getId());
        student.setRole("STUDENT");
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> deleteById(int studentId) {
        checkIfStudentIsExistOrThrowException(studentId);
        studentRepository.deleteById(studentId);
        return new ResponseEntity<>("Deleted Success...", HttpStatus.ACCEPTED);
    }


    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId).orElseThrow(() ->
                new NoSuchElementException("There Are No Student With Id = " + studentId));
    }

    private void checkIfStudentIsExistOrThrowException(int studentId) {
        getStudentById(studentId);
    }

}
