package com.ibm.controller;

import com.ibm.dto.EmployeeRequestResponseDTO;
import com.ibm.model.EmployeeRequest;
import com.ibm.service.EmployeeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-requests")
public class EmployeeRequestController {

    @Autowired
    private EmployeeRequestService employeeRequestService;

    @PostMapping
    public EmployeeRequest submitRequest(@RequestBody EmployeeRequest request) {
        return employeeRequestService.submitRequest(request);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        employeeRequestService.deleteRequest(id);
    }

    @GetMapping("/employee/{empId}")
    public List<EmployeeRequest> getRequestsByEmployee(@PathVariable Long empId) {
        return employeeRequestService.getRequestsByEmployee(empId);
    }

    @GetMapping("/employee/{empId}/details")
    public List<EmployeeRequestResponseDTO> getDetailedRequests(@PathVariable Long empId) {
        return employeeRequestService.getRequestsByEmployeeDTO(empId);
    }

    @PutMapping("/{requestId}/status")
    public void updateRequestStatus(@PathVariable Long requestId, @RequestParam String status) {
        employeeRequestService.updateRequestStatus(requestId, status);
    }
}