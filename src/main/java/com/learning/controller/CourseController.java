package com.learning.controller;

import com.learning.model.Course;
import com.learning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return courseService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Course course) {
        return courseService.add(course);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Course course) {
        return courseService.update(course);
    }

    @DeleteMapping("/deleteById/{courseId}")
    public ResponseEntity<?> deleteById(@PathVariable int courseId) {
        return courseService.deleteById(courseId);
    }

}
