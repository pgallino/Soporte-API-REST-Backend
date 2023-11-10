package com.aninfo.service;

import com.aninfo.model.Ticket;
import com.aninfo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket account) {
        return ticketRepository.save(account);
    }

    public Collection<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findById(Long cbu) {
        return ticketRepository.findById(cbu);
    }

    public void save(Ticket account) {
        ticketRepository.save(account);
    }

    public void deleteById(Long cbu) {
        ticketRepository.deleteById(cbu);
    }

}
