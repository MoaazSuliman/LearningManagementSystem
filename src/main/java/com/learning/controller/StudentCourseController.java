package com.learning.controller;

import com.learning.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/StudentsAndCourses")
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping("/registerInCourse/{studentId}/course/{courseId}")
    public ResponseEntity<?> registerInCourse(@PathVariable int studentId, @PathVariable int courseId) {
        return studentCourseService.registerStudentToCourse(studentId, courseId);
    }

    @GetMapping("/getAllCourseForStudentByStudentId/{studentId}")
    public ResponseEntity<?> getAllCourseForStudentByStudentId(@PathVariable int studentId) {
        return studentCourseService.getAllCoursesForStudentByStudentId(studentId);
    }
}
