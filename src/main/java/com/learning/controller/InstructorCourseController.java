package com.learning.controller;

import com.learning.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructors")
public class InstructorCourseController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/getCoursesForInstructor/{instructorId}")
    public ResponseEntity<?> getInstructorCourses(@PathVariable int instructorId) {
        return instructorService.getCoursesForInstructor(instructorId);
    }
}
