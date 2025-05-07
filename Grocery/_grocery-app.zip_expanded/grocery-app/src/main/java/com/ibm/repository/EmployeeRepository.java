package com.ibm.repository;
import com.ibm.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email); // Custom query to find an employee by email
}
