package com.ibm.service;

import com.ibm.dto.EmployeeRequestResponseDTO;
import com.ibm.model.EmployeeRequest;
import com.ibm.repository.EmployeeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeRequestService {

    @Autowired
    private EmployeeRequestRepository requestRepo;

    public EmployeeRequest submitRequest(EmployeeRequest request) {
        request.setStatus("PENDING");
        return requestRepo.save(request);
    }

    public void deleteRequest(Long id) {
        requestRepo.deleteById(id);
    }

    public List<EmployeeRequest> getRequestsByEmployee(Long empId) {
        return requestRepo.findByEmployeeId(empId);
    }

    public List<EmployeeRequestResponseDTO> getRequestsByEmployeeDTO(Long empId) {
        return requestRepo.findByEmployeeId(empId).stream().map(req -> new EmployeeRequestResponseDTO(
                req.getId(),
                req.getAction(),
                req.getRequestedQuantity(),
                req.getStatus(),
                req.getEmployee().getId(),
                req.getEmployee().getFirstname() + " " + req.getEmployee().getLastname(),
                req.getProduct().getId(),
                req.getProduct().getName()
        )).collect(Collectors.toList());
    }

    public void updateRequestStatus(Long requestId, String status) {
        EmployeeRequest request = requestRepo.findById(requestId)
            .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(status.toUpperCase());
        requestRepo.save(request);
    }
}
