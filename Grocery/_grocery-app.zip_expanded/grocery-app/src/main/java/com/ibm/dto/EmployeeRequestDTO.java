package com.ibm.dto;

public class EmployeeRequestDTO {
    private Long id;
    private Long employeeId;
    private Long productId;
    private String action;
    private int requestedQuantity;
    private String status;

    // ✅ Proper constructor
    public EmployeeRequestDTO(Long id, Long employeeId, Long productId, String action, int requestedQuantity, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.productId = productId;
        this.action = action;
        this.requestedQuantity = requestedQuantity;
        this.status = status;
    }

    public EmployeeRequestDTO() {}

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public int getRequestedQuantity() { return requestedQuantity; }
    public void setRequestedQuantity(int requestedQuantity) { this.requestedQuantity = requestedQuantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
