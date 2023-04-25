package com.learning.service;

import com.learning.model.Course;
import com.learning.model.Student;
import com.learning.model.StudentCourse;
import com.learning.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StudentCourseService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseServiceImp courseServiceImp;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public ResponseEntity<?> registerStudentToCourse(int studentId, int courseId) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseServiceImp.getById(courseId);

        return addCourseToStudent(student, course);
    }

    public StudentCourse update(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    public StudentCourse getByStudentAndCourse(Student student, Course course) {
        return studentCourseRepository.findByStudentAndCourse(student, course).orElseThrow(
                () -> new NoSuchElementException("There Are No Student Course With This Student And This Course.")
        );
    }


    public ResponseEntity<?> getStudentsForCourseByCourseId(int courseId) {
        Course course = courseServiceImp.getById(courseId);

        return new ResponseEntity<>(studentCourseRepository.findAllByCourse(course), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> getAllCoursesForStudentByStudentId(int studentId) {
        Student student = studentService.getStudentById(studentId);

        return new ResponseEntity<>(studentCourseRepository.findAllByStudent(student), HttpStatus.ACCEPTED);
    }

    private ResponseEntity<?> addCourseToStudent(Student student, Course course) {
        StudentCourse studentCourse = new StudentCourse(0, student, course, 0);
        return new ResponseEntity<>(studentCourseRepository.save(studentCourse), HttpStatus.CREATED);
    }

}
