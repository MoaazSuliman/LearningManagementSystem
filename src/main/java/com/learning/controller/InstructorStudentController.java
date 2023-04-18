package com.learning.controller;

import com.learning.service.InstructorStudentService;
import com.learning.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
public class InstructorStudentController {
    @Autowired
    private InstructorStudentService instructorStudentService;
    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping("/getStudentsForCourseByCourseId/{courseId}")
    public ResponseEntity<?> getStudentsForCourseByCourseId(@PathVariable int courseId) {
        return studentCourseService.getStudentsForCourseByCourseId(courseId);
    }


    @PutMapping("/putDegreeForStudent/student/{studentId}/course/{courseId}/degree/{degree}")
    public ResponseEntity<?> putDegreeForStudent(@PathVariable int studentId, @PathVariable int courseId, @PathVariable double degree) {
        return instructorStudentService.putDegreeForStudentInSpecificCourseByInstructor(studentId, courseId, degree);
    }
}
