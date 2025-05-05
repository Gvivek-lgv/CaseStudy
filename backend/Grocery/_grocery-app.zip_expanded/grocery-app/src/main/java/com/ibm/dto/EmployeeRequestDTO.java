package com.ibm.dto;

public class EmployeeRequestDTO {
    private Long id;
    private Long employeeId;
    private String requestType;
    private String status;

    public EmployeeRequestDTO() {}

    public EmployeeRequestDTO(Long id, Long employeeId, String requestType, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.requestType = requestType;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getRequestType() { return requestType; }
    public void setRequestType(String requestType) { this.requestType = requestType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
