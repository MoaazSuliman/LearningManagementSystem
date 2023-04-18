package com.learning.repository;

import com.learning.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Optional<Admin> findByEmailAndPassword(String email, String password);
}
