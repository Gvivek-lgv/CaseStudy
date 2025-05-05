package com.ibm.dto;

public class TicketDTO {
    private Long id;
    private Long userId;
    private String message;

    public TicketDTO() {}

    public TicketDTO(Long id, Long userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
