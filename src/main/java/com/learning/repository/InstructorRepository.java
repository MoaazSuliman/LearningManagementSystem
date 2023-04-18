package com.learning.repository;

import com.learning.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    public Optional<Instructor> findByEmailAndPassword(String email, String password);
}
