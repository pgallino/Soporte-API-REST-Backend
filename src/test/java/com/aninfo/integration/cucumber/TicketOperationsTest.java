package com.aninfo.integration.cucumber;

import com.aninfo.exceptions.TicketNoEncontradoException;
import com.aninfo.model.Ticket;
import com.aninfo.model.TaskTicketAssociation;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TicketOperationsTest extends TicketIntegrationServiceTest{
    Ticket ticket;
    Optional<Collection<Ticket>> buscados;
    Optional<Ticket> buscado;
    Exception exception;

    @Given("^un ticket de id (\\d+)$")
    public void un_ticket_de_id(long arg1) throws Throwable {
        ticket = crearTicket();
    }

    @When("^busco ticket por id (\\d+)$")
    public void busco_ticket_por_id(long arg1) throws Throwable {
        try {
            buscado = getTicketById(arg1);
        } catch (TicketNoEncontradoException e) {
            exception = e;
        }
    }

    @Then("^se retorna el ticket de id (\\d+)$")
    public void se_retorna_el_ticket_de_id(long arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        buscado.ifPresent(value -> assertEquals(ticket.getId(), value.getId()));
    }

    @Then("^no se encuentra el ticket$")
    public void noSeEncuentraElTicket() {
        assertNotNull(exception);
    }

}
