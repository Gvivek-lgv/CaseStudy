package com.ibm.service;

import com.ibm.model.Employee;
import com.ibm.model.User;
import com.ibm.repository.EmployeeRepository;
import com.ibm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    public Employee getEmployeeByEmail(String email) {
        return empRepo.findByEmail(email);
    }

    public Employee saveEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee emp = empRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setFirstname(updatedEmployee.getFirstname());
        emp.setLastname(updatedEmployee.getLastname());
        emp.setEmail(updatedEmployee.getEmail());
        emp.setPassword(updatedEmployee.getPassword());
        return empRepo.save(emp);
    }

    public void deleteEmployee(Long id) {
        empRepo.deleteById(id);
    }

    public boolean authenticate(String email, String password) {
        Employee emp = empRepo.findByEmail(email);
        return emp != null && emp.getPassword().equals(password);
    }

    public void unlockUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setLocked(false);
        user.setFailedLoginAttempts(0);
        userRepo.save(user); 
    }
}
