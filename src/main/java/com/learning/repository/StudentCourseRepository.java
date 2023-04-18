package com.learning.repository;

import com.learning.model.Course;
import com.learning.model.Student;
import com.learning.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
    public List<StudentCourse> findAllByStudent(Student student);

    public List<StudentCourse> findAllByCourse(Course course);

    public Optional<StudentCourse> findByStudentAndCourse(Student student, Course course);
}
