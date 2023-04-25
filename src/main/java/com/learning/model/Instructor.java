package com.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Instructor extends Person {

    @ManyToMany
    private List<Course> courses;


    public void addCourse(Course course) {
        if (this.courses == null)
            this.courses = new ArrayList<>();
        this.courses.add(course);
    }
}
