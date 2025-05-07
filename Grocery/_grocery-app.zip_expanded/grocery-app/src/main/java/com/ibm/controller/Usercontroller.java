package com.ibm.controller;

import com.ibm.dto.UserLoginDTO;
import com.ibm.dto.UserUpdateDTO;
import com.ibm.model.User;
import com.ibm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // ✅ UPDATED LOGIN ENDPOINT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO dto) {
        Optional<User> userOpt = userService.getUserByEmail(dto.getEmail());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        User user = userOpt.get();

        if (user.isLocked()) {
            return ResponseEntity.status(403).body("Account is locked. Raise ticket.");
        }

        if (!user.getPassword().equals(dto.getPassword())) {
            user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);
            if (user.getFailedLoginAttempts() >= 3) {
                user.setLocked(true);
            }
            userService.saveUser(user);
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        user.setFailedLoginAttempts(0);
        userService.saveUser(user);

        return ResponseEntity.ok(user.getId()); // ✅ return numeric ID
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserUpdateDTO dto) {
        userService.updateUser(dto);
        return ResponseEntity.ok("Profile updated successfully");
    }
}
