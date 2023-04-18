package com.learning.service;

import com.learning.model.Course;
import com.learning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<?> add(Course course) {
        return new ResponseEntity<>(courseRepository.save(course), HttpStatus.CREATED);
    }

    public ResponseEntity<?> update(Course course) {
        if (isExist(course.getId()))
            return new ResponseEntity<>(courseRepository.save(course), HttpStatus.ACCEPTED);

        return new ResponseEntity<>("There Are No Course With Id " + course.getId()
                , HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> getAll() {
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int id) {

        if (!isExist(id)) {
            return new ResponseEntity<>("Not Found Course With Id " + id, HttpStatus.NOT_FOUND);
        }
        courseRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Success.", HttpStatus.ACCEPTED);

    }

    public Course getById(int courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    private boolean isExist(int courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        return (course == null) ? false : true;
    }
}
