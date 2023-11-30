package com.aninfo.service;

import com.aninfo.model.Ticket;
import com.aninfo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Ticket createTicket(Ticket account) {
        return ticketRepository.save(account);
    }

    public Collection<Ticket> getTickets(long productid, long versionid) {
        List<Ticket> allTickets = ticketRepository.findAll();
        Collection<Ticket> validTickets = new ArrayList<>();
        for (Ticket ticket : allTickets) {
            if (ticket.getproductId() == productid && ticket.getversionId() == versionid) {
                validTickets.add(ticket);
                }
        }
        return validTickets;
    }

    public Optional<Ticket> findById(Long cbu) {
        return ticketRepository.findById(cbu);
    }

    public void save(Ticket account) {
        ticketRepository.save(account);
    }
    public ResponseEntity<Ticket> updateTicket(Ticket ticket, long productId, long versionId){
        Optional<Ticket> aTicket = ticketRepository.findTicketByid(ticket.getId());
        if (!aTicket.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        aTicket.get().update(ticket);
        ticketRepository.save(aTicket.get());
        return ResponseEntity.ok().build();
    }

    public void deleteById(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

}
