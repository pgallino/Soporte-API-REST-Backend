package com.aninfo.service;

import com.aninfo.exceptions.TicketNoEncontradoException;
import com.aninfo.model.Ticket;
import com.aninfo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TaskTicketAssociationService taskTicketAssociationService;

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    public Optional<Ticket> getTicket(long id_ticket) {
        return ticketRepository.findById(id_ticket);
    }
    public Collection<Ticket> getTickets(long productid, long versionid) {
        List<Ticket> allTickets = ticketRepository.findAll();
        Collection<Ticket> validTickets = new ArrayList<>();
        for (Ticket ticket : allTickets) {
            if (ticket.getProducto_id() == productid && ticket.getVersion_id() == versionid) {
                validTickets.add(ticket);
                }
        }
        return validTickets;
    }

    public Collection<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isEmpty()) {
            throw new TicketNoEncontradoException("No se encontró el ticket");
        } else return ticket;
    }

    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public ResponseEntity<Ticket> updateTicket(Ticket ticket, long productId, long versionId){
        Optional<Ticket> aTicket = ticketRepository.findById(ticket.getId_ticket());
        if (aTicket.isEmpty()) {
            throw new TicketNoEncontradoException("No se encontró el ticket");
        } else {
            aTicket.get().update(ticket);
            ticketRepository.save(aTicket.get());
            return ResponseEntity.ok().build();
        }
    }

    public void deleteById(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

}
