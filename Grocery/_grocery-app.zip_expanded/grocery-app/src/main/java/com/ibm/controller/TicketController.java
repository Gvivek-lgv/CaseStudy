package com.ibm.controller;

import com.ibm.model.Ticket;
import com.ibm.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/user/{userId}")
    public List<Ticket> getTicketsByUser(@PathVariable Long userId) {
        return ticketService.getTicketsByUser(userId);
    }

    @PostMapping
    public Ticket raiseTicket(@RequestBody Ticket ticket) {
        return ticketService.raiseTicket(ticket);
    }

    @DeleteMapping("/{id}")
    public void closeTicket(@PathVariable Long id) {
        ticketService.closeTicket(id);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestParam String status) {
        ticketService.updateStatus(id, status);
        return ResponseEntity.ok("Ticket status updated to: " + status);
    }
}
