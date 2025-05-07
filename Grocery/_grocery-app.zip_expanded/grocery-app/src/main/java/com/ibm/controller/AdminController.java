package com.ibm.controller;
import com.ibm.dto.AdminLoginDTO;
import com.ibm.dto.AdminPasswordDTO;
import com.ibm.model.Admin;
import com.ibm.service.AdminService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/{email}")//working
    public Optional<Admin> getAdminByEmail(@PathVariable String email) {
        return adminService.getAdminByEmail(email);
    }
    @PostMapping//working
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
    @PostMapping("/admin/set-password")//working
    public ResponseEntity<String> setPassword(@RequestBody AdminPasswordDTO dto) {
        adminService.updateAdminPassword(dto);
        return ResponseEntity.ok("Password updated successfully");
    }
    @PostMapping("/login")//working
    public ResponseEntity<String> login(@RequestBody AdminLoginDTO dto) {
        boolean success = adminService.authenticate(dto.getEmail(), dto.getPassword());
        if (success) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }


}