package com.ibm.service;

import com.ibm.model.Admin;
import com.ibm.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;

    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin getAdminByEmail(String email) {
        return adminRepo.findByEmail(email);
    }

    public void deleteAdmin(Long id) {
        adminRepo.deleteById(id);
    }
}
