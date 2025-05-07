package com.ibm.service;

import com.ibm.dto.AdminPasswordDTO;
import com.ibm.model.Admin;
import com.ibm.repository.AdminRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;

    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Optional<Admin> getAdminByEmail(String email) {
        return adminRepo.findByEmail(email);
    }
    public boolean authenticate(String email, String password) {
        Optional<Admin> adminOpt = adminRepo.findByEmailAndPassword(email, password);
        return adminOpt.isPresent();
    }


    public void deleteAdmin(Long id) {
        adminRepo.deleteById(id);
    }
    public void updateAdminPassword(AdminPasswordDTO dto) {
        Admin admin = adminRepo.findById(dto.getId())
            .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            admin.setPassword(dto.getPassword()); // You may hash this password here
        } else {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }

        adminRepo.save(admin);
    }

}
