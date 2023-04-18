package com.learning.controller;

import com.learning.model.Student;
import com.learning.service.StudentCourseService;
import com.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Student student) {
        return studentService.register(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return studentService.getAll();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/deleteById/{studentId}")
    public ResponseEntity<?> deleteById(@PathVariable int studentId) {
        return studentService.deleteById(studentId);
    }

    @GetMapping("/registerInCourse/{studentId}/course/{courseId}")
    public ResponseEntity<?> registerInCourse(@PathVariable int studentId, @PathVariable int courseId) {
        return studentCourseService.registerStudentToCourse(studentId, courseId);
    }

    @GetMapping("/getAllCourseForStudentByStudentId/{studentId}")
    public ResponseEntity<?> getAllCourseForStudentByStudentId(@PathVariable int studentId) {
        return studentCourseService.getStudentsForCourseByCourseId(studentId);
    }

}
