package com.learning.controller;

import com.learning.model.Instructor;
import com.learning.service.InstructorService;
import com.learning.service.InstructorStudentService;
import com.learning.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private InstructorStudentService instructorStudentService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return instructorService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Instructor instructor) {
        return instructorService.add(instructor);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Instructor instructor) {
        return instructorService.update(instructor);
    }

    @DeleteMapping("/deleteById/{instructorId}")
    public ResponseEntity<?> deleteById(@PathVariable int instructorId) {
        return instructorService.deleteById(instructorId);
    }






}
