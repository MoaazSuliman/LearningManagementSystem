package com.learning.service;

import com.learning.model.Course;
import com.learning.repository.CourseRepository;
import com.learning.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseRepository courseRepository;


    @Override
    public ResponseEntity<?> addCourse(Course course) {
        return new ResponseEntity<>(courseRepository.save(course), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateCourse(Course course) {
        checkIfCourseIsExistOrThrowException(course.getId());
        return new ResponseEntity<>(courseRepository.save(course)
                                   , HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> getAllCourses() {
        return new ResponseEntity(courseRepository.findAll(),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteCourseById(int id) {

        checkIfCourseIsExistOrThrowException(id);
        courseRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Success.", HttpStatus.ACCEPTED);

    }

    public Course getById(int courseId) {
        return courseRepository.findById(courseId).
                orElseThrow(() -> new NoSuchElementException("There Are No Course With Id = " + courseId));
    }

    private void checkIfCourseIsExistOrThrowException(int courseId) {
        getById(courseId);

    }
}
