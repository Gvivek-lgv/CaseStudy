package com.ibm.service;

import com.ibm.dto.UserUpdateDTO;
import com.ibm.model.User;
import com.ibm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
    public String loginUser(String email, String password) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        if (userOpt.isEmpty()) return "User not found";

        User user = userOpt.get();
        if (user.isLocked()) return "Account is locked. Raise ticket.";

        if (!user.getPassword().equals(password)) {
            user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);
            if (user.getFailedLoginAttempts() >= 3) {
                user.setLocked(true);
            }
            userRepo.save(user);
            return "Invalid credentials";
        }

        user.setFailedLoginAttempts(0); // Reset on success
        userRepo.save(user);
        return "Login successful";
    }
    public void updateUser(UserUpdateDTO dto) {
        User user = userRepo.findById(dto.getId())
            .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setDob(dto.getDob());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());

        userRepo.save(user);
    }


}
