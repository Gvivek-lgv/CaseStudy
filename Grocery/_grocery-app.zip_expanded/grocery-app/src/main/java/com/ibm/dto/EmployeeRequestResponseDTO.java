package com.ibm.dto;

public class EmployeeRequestResponseDTO {
    private Long id;
    private String action;
    private int requestedQuantity;
    private String status;

    // Employee details
    private Long employeeId;
    private String employeeName;

    // Product details
    private Long productId;
    private String productName;

    public EmployeeRequestResponseDTO() {}

    public EmployeeRequestResponseDTO(Long id, String action, int requestedQuantity, String status,
                                      Long employeeId, String employeeName,
                                      Long productId, String productName) {
        this.id = id;
        this.action = action;
        this.requestedQuantity = requestedQuantity;
        this.status = status;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.productId = productId;
        this.productName = productName;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public int getRequestedQuantity() { return requestedQuantity; }
    public void setRequestedQuantity(int requestedQuantity) { this.requestedQuantity = requestedQuantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
}
