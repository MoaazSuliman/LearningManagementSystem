package com.learning.controller;

import com.learning.service.InstructorCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private InstructorCourseService instructorCourseService;

    @PostMapping("/assignTo/{instructorId}/course/{courseId}")
    public ResponseEntity<?> assignCourseToInstructor(@PathVariable int instructorId, @PathVariable int courseId) {
        return instructorCourseService.assignCourseToInstructor(instructorId, courseId);
    }
}
