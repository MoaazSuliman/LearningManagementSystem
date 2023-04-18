package com.learning.service;

import com.learning.model.Course;
import com.learning.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InstructorCourseService {

    @Autowired
    private InstructorService instructorService;
    @Autowired
    private CourseService courseService;

    public ResponseEntity<?> assignCourseToInstructor(int instructorId, int courseId) {
        Instructor instructor = instructorService.getById(instructorId);
        if (instructor == null)
            return new ResponseEntity<>("There Are No Instructor With Id= " + instructorId, HttpStatus.NOT_FOUND);
        Course course = courseService.getById(courseId);
        if (course == null)
            return new ResponseEntity<>("There Are No Course With Id= " + courseId, HttpStatus.NOT_FOUND);
        return addCourseToInstructorThenUpdateInstructor(instructor, course);
    }


    private ResponseEntity<?> addCourseToInstructorThenUpdateInstructor(Instructor instructor, Course course) {
        instructor.getCourses().add(course);
        instructorService.update(instructor);
        return new ResponseEntity<>("Assigned Success.", HttpStatus.ACCEPTED);
    }
}
