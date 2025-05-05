package com.ibm.service;

import com.ibm.model.Employee;
import com.ibm.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    public Employee saveEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    public Employee getEmployeeByEmail(String email) {
        return empRepo.findByEmail(email);
    }

    public void deleteEmployee(Long id) {
        empRepo.deleteById(id);
    }
}
