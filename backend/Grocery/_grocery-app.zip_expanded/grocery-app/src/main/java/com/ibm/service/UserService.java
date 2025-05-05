package com.ibm.service;

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
}
