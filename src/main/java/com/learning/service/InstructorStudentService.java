package com.learning.service;

import com.learning.model.Course;
import com.learning.model.Student;
import com.learning.model.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InstructorStudentService {

    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    public ResponseEntity<?> putDegreeForStudentInSpecificCourseByInstructor(int studentId, int courseId, double degree) {
        Student student = studentService.getStudentById(studentId);
        if (student == null)
            return new ResponseEntity<>("There Are No Student With Id  " + studentId, HttpStatus.NOT_FOUND);
        Course course = courseService.getById(courseId);
        if (course == null)
            return new ResponseEntity<>("There Are No Course With Id  " + courseId, HttpStatus.NOT_FOUND);
        StudentCourse studentCourse = studentCourseService.getByStudentAndCourse(student, course);
        studentCourse.setDegree(degree);
        return new ResponseEntity<>(studentCourseService.update(studentCourse), HttpStatus.ACCEPTED);

    }
}
