package com.learning.service.interfaces;

import com.learning.model.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {

    public ResponseEntity<?> addCourse(Course course);

    public ResponseEntity<?> updateCourse(Course course);

    public ResponseEntity<?> deleteCourseById(int courseId);

    public ResponseEntity<?> getAllCourses();
}
