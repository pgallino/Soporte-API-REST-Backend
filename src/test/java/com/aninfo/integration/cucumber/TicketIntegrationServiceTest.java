package com.aninfo.integration.cucumber;

import com.aninfo.SoporteApp;
import com.aninfo.model.Ticket;
import com.aninfo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Collection;
import java.util.Optional;

@ContextConfiguration(classes = SoporteApp.class)
@WebAppConfiguration
public class TicketIntegrationServiceTest {
    @Autowired
    TicketService ticketService;

    Ticket crearTicket() {
        return ticketService.createTicket(new Ticket());
    }

    Optional<Ticket> getTicketById(Long id) {
        return ticketService.findById(id);
    }

    Optional<Collection<Ticket>> getTickets(long productid, long versionid) {
        return Optional.ofNullable(ticketService.getTickets(productid, versionid));
    }

    void updateTicket(Ticket ticket, long productId, long versionId) {
        ticketService.updateTicket(ticket, productId, versionId);
    }

}
