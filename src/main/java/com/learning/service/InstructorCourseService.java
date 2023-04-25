package com.learning.service;

import com.learning.model.Course;
import com.learning.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorCourseService {

    @Autowired
    private InstructorService instructorService;
    @Autowired
    private CourseServiceImp courseServiceImp;

    public ResponseEntity<?> assignCourseToInstructor(int instructorId, int courseId) {
        Instructor instructor = instructorService.getById(instructorId);

        Course course = courseServiceImp.getById(courseId);

        return addCourseToInstructorThenUpdateInstructor(instructor, course);
    }


    private ResponseEntity<?> addCourseToInstructorThenUpdateInstructor(Instructor instructor, Course course) {
        // get all courses for instructor
        List<Course> instructorCourses = instructor.getCourses();
        // add this course for instructor courses
        instructorCourses.add(course);
        // Dependency Injection.==> set this courses for instructor By Setter Method.
        instructor.setCourses(instructorCourses);
        // update instructor in db .
        instructorService.update(instructor);
        return new ResponseEntity<>("Assigned Success.", HttpStatus.ACCEPTED);
    }
}
