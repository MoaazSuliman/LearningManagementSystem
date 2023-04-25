package com.learning.controller;

import com.learning.model.Course;
import com.learning.service.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseServiceImp courseServiceImp;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return courseServiceImp.getAllCourses();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Course course) {
        return courseServiceImp.addCourse(course);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Course course) {
        return courseServiceImp.updateCourse(course);
    }

    @DeleteMapping("/deleteById/{courseId}")
    public ResponseEntity<?> deleteById(@PathVariable int courseId) {
        return courseServiceImp.deleteCourseById(courseId);
    }

}
