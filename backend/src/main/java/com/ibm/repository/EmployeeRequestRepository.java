package com.ibm.repository;

import com.ibm.model.EmployeeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRequestRepository extends JpaRepository<EmployeeRequest, Long> {
    List<EmployeeRequest> findByEmployeeId(Long empId);
}
