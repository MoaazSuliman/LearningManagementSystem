package com.learning.service;

import com.learning.model.Course;
import com.learning.model.Student;
import com.learning.model.StudentCourse;
import com.learning.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentCourseRepository studentCourseRepository;


    public StudentCourse update(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    public StudentCourse getByStudentAndCourse(Student student, Course course) {
        return studentCourseRepository.findByStudentAndCourse(student, course).orElse(null);
    }

    public ResponseEntity<?> registerStudentToCourse(int studentId, int courseId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null)
            return new ResponseEntity<>("There Are No Student With id =" + studentId, HttpStatus.NOT_FOUND);
        Course course = courseService.getById(courseId);
        if (course == null)
            return new ResponseEntity<>("There Are No Course With id =" + courseId, HttpStatus.NOT_FOUND);
        return addCourseToStudent(student, course);
    }

    public ResponseEntity<?> getStudentsForCourseByCourseId(int courseId) {
        Course course = courseService.getById(courseId);
        if (course == null)
            return new ResponseEntity<>("There Are No Course With Id = " + courseId, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(studentCourseRepository.findAllByCourse(course), HttpStatus.ACCEPTED);
    }


    private ResponseEntity<?> addCourseToStudent(Student student, Course course) {
        StudentCourse studentCourse = new StudentCourse(0, student, course, 0);
        return new ResponseEntity<>(studentCourseRepository.save(studentCourse), HttpStatus.CREATED);

    }
}
