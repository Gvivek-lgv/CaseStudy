package com.ibm.repository;

import com.ibm.model.Admin;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    // Custom finder to support login
    Optional<Admin> findByEmailAndPassword(String email, String password);

    // Optional: Find by email only (useful for login + password check manually)
    Optional<Admin> findByEmail(String email);
}
