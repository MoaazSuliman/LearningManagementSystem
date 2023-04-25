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
    private CourseServiceImp courseServiceImp;

    public ResponseEntity<?> putDegreeForStudentInSpecificCourseByInstructor(int studentId, int courseId, double degree) {
        Student student = studentService.getStudentById(studentId);

        Course course = courseServiceImp.getById(courseId);

        StudentCourse studentCourse = studentCourseService.getByStudentAndCourse(student, course);

        studentCourse.setDegree(degree);
        return new ResponseEntity<>(studentCourseService.update(studentCourse), HttpStatus.ACCEPTED);

    }
}
