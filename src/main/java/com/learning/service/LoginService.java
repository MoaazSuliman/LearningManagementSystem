package com.learning.service;

import com.learning.model.Admin;
import com.learning.model.Instructor;
import com.learning.model.Student;
import com.learning.repository.AdminRepository;
import com.learning.repository.InstructorRepository;
import com.learning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<?> login(String email, String password) {
        Student student = studentRepository.findByEmailAndPassword(email, password).orElse(null);
        if (student != null)
            return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
        Instructor instructor = instructorRepository.findByEmailAndPassword(email, password).orElse(null);
        if (instructor != null)
            return new ResponseEntity<>(instructor, HttpStatus.ACCEPTED);

        Admin admin = adminRepository.findByEmailAndPassword(email, password).orElse(null);
        if (admin != null)
            return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);

        return new ResponseEntity<>("Error In Email Or Password", HttpStatus.BAD_REQUEST);
    }




}
