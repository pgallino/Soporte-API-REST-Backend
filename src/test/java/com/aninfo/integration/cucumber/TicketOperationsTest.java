package com.aninfo.integration.cucumber;

import com.aninfo.exceptions.TicketNoEncontradoException;
import com.aninfo.model.Ticket;
import com.aninfo.model.TaskTicketAssociation;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TicketOperationsTest extends TicketIntegrationServiceTest{
    Ticket ticket;
    Optional<Collection<Ticket>> buscados;
    Optional<Ticket> buscado;
    Exception exception;
    Exception exception_2;

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
        buscado.ifPresent(value -> assertEquals(ticket.getId_ticket(), value.getId_ticket()));
    }

    @Then("^no se encuentra el ticket$")
    public void noSeEncuentraElTicket() {
        assertNotNull(exception);
    }

    @Given("^un ticket del producto (\\d+) y version (\\d+)$")
    public void unTicketDelProductoYVersion(long arg0, long arg1) {
        ticket = crearTicket();
        ticket.setProducto_id(arg0);
        ticket.setVersion_id(arg1);
    }

    @When("^busco tickets del producto (\\d+) y version (\\d+)$")
    public void buscoTicketsDelProductoYVersion(long arg0, long arg1) {
        buscados = getTickets(arg0, arg1);
    }

    @Then("^se retornan los tickets del producto (\\d+) y version (\\d+)$")
    public void seRetornanLosTicketsDelProductoYVersion(long arg0, long arg1) {
        if (buscados.isPresent()) {
            Collection<Ticket> listado = buscados.get();
            Iterator<Ticket> it = listado.iterator();
            while(it.hasNext()) {
                Ticket ticket_listado = it.next();
                assertEquals(arg0, ticket_listado.getProducto_id());
                assertEquals(arg1, ticket_listado.getVersion_id());
            }
        }
    }

    @Then("^no se encuentran tickets del producto (\\d+) y version (\\d+)$")
    public void noSeEncuentranTicketsDelProductoYVersion(long arg0, long arg1) {
        if (buscados.isPresent()) {
            Collection<Ticket> listado = buscados.get();
            Iterator<Ticket> it = listado.iterator();
            while(it.hasNext()) {
                Ticket ticket_listado = it.next();
                assertTrue(arg0 != ticket_listado.getProducto_id() || arg1 != ticket_listado.getVersion_id());
            }
        }
    }

    @Given("^un ticket con estado \"([^\"]*)\"$")
    public void unTicketConEstado(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ticket = ticketService.createTicket(new Ticket("", "", arg0, "", "", 0, 0, "", 0, 0, ""));
    }

    @When("^cambio el estado a \"([^\"]*)\"$")
    public void cambioElEstadoA(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ticket.setEstado(arg0);
    }

    @Then("^el estado del ticket es \"([^\"]*)\"$")
    public void elEstadoDelTicketEs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(ticket.getEstado(), arg0);
    }

    @Given("^un ticket con prioridad \"([^\"]*)\"$")
    public void unTicketConPrioridad(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ticket = ticketService.createTicket(new Ticket("", "", "", "", arg0, 0, 0, "", 0, 0, ""));
    }

    @When("^cambio la prioridad a \"([^\"]*)\"$")
    public void cambioLaPrioridadA(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ticket.setPrioridad(arg0);
    }

    @Then("^la prioridad del ticket es \"([^\"]*)\"$")
    public void laPrioridadDelTicketEs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(ticket.getPrioridad(), arg0);
    }

    @Given("^un ticket con severidad \"([^\"]*)\"$")
    public void unTicketConSeveridad(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ticket = ticketService.createTicket(new Ticket("", "", "", arg0, "", 0, 0, "", 0, 0, ""));
    }

    @When("^cambio la severidad a \"([^\"]*)\"$")
    public void cambioLaSeveridadA(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ticket.setSeveridad(arg0);
    }

    @Then("^la severidad del ticket es \"([^\"]*)\"$")
    public void laSeveridadDelTicketEs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(ticket.getSeveridad(), arg0);
    }

    @When("^elimino el ticket de id (\\d+)$")
    public void eliminoElTicketDeId(long arg0) {
        try {
            ticketService.deleteById(arg0);
        } catch (EmptyResultDataAccessException e) {
            exception_2 = e;
        }
    }

    @Then("^se elimina el ticket de id (\\d+)$")
    public void seEliminaElTicketDeId(long arg0) {
        try {
            getTicketById(arg0);
        } catch (TicketNoEncontradoException e) {
            exception = e;
        }
        assertNotNull(exception);
        exception = null;
    }

    @Then("^no se elimina el ticket de id (\\d+)$")
    public void noSeEliminaElTicketDeId(long arg0) {

        assertNotNull(exception_2);
    }
}
