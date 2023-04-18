package com.learning.service;

import com.learning.model.Student;
import com.learning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<?> register(Student student) {
        student.setRole("STUDENT");
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(Student student) {
        if (!isExist(student.getId()))
            return new ResponseEntity<>("There Are No Student With id = " + student.getId(), HttpStatus.NOT_FOUND);
        student.setRole("STUDENT");
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> deleteById(int studentId) {
        if (!isExist(studentId))
            return new ResponseEntity<>("There Are No Student With id = " + studentId, HttpStatus.NOT_FOUND);
        studentRepository.deleteById(studentId);
        return new ResponseEntity<>("Deleted Success...", HttpStatus.ACCEPTED);
    }


    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    private boolean isExist(int studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        return (student == null) ? false : true;
    }

}
