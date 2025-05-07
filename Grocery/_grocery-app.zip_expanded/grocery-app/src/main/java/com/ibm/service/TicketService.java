package com.ibm.service;

import com.ibm.model.Ticket;
import com.ibm.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepo;

    public List<Ticket> getTicketsByUser(Long userId) {
        return ticketRepo.findByUserId(userId);
    }

    public Ticket raiseTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    public void closeTicket(Long id) {
        ticketRepo.deleteById(id);
    }

    public void updateStatus(Long id, String status) {
        Ticket ticket = ticketRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setStatus(status);
        if ("RESOLVED".equalsIgnoreCase(status)) {
            ticket.setResolvedAt(java.time.LocalDateTime.now());
        }
        ticketRepo.save(ticket);
    }
}
