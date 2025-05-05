package com.ibm.service;

import com.ibm.model.EmployeeRequest;
import com.ibm.repository.EmployeeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRequestService {

    @Autowired
    private EmployeeRequestRepository requestRepo;

    public List<EmployeeRequest> getRequestsByEmployee(Long empId) {
        return requestRepo.findByEmployeeId(empId);
    }

    public EmployeeRequest submitRequest(EmployeeRequest request) {
        return requestRepo.save(request);
    }

    public void deleteRequest(Long id) {
        requestRepo.deleteById(id);
    }
}
