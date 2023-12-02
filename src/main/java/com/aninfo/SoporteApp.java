package com.aninfo;

import com.aninfo.model.*;
import com.aninfo.service.TaskTicketAssociationService;
import com.aninfo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@SpringBootApplication
@EnableSwagger2
public class SoporteApp {

	/* servicios */
	@Autowired
	private TicketService ticketService;
	@Autowired
	private TaskTicketAssociationService ticketAssociationService;


	public static void main(String[] args) {
		SpringApplication.run(SoporteApp.class, args);
	}

	/* END-POINTS */
	/* Crear Ticket */
	@PostMapping("/Tickets")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket createTicket(@RequestBody Ticket ticket) {return ticketService.createTicket(ticket);}

	/* Actualizar Ticket */
	@PutMapping("/Ticket")
	public ResponseEntity<Ticket>  updateTicket(@RequestBody Ticket ticket) {
		long productId = ticket.getproductId();
		long versionId = ticket.getversionId();
		return ticketService.updateTicket(ticket,productId,versionId);
	}
	/* Pedir Tickets para una version de un producto */
	@GetMapping("/Ticket/{productId}/{versionId}")
	public Collection<Ticket> getTickets(@PathVariable long productId, @PathVariable long versionId) {return ticketService.getTickets(productId,versionId);}

	/* Crear asociacion ticket-task */
	@PostMapping("/Ticket/Task")
	@ResponseStatus(HttpStatus.CREATED)
	public TaskTicketAssociation association(@RequestBody TaskTicketAssociation taskTicket){
		return ticketAssociationService.createTaskTicketAssociation(taskTicket);
	}
	/* Borrar Ticket y sus asociaciones */
	@DeleteMapping("/Ticket/{ticketId}")
	public void deleteTicket(@PathVariable long ticketId){
		ticketService.deleteById(ticketId);
		ticketAssociationService.deleteTaskTicketAssociationByTicketId(ticketId);
	}
	/* Borrar todas las asociaciones de tickets hacia una tarea */
	@DeleteMapping("/Ticket/Task/{taskId}")
	public void deleteAsociationsWithTask(@PathVariable long taskId){
		ticketAssociationService.deleteTaskTicketAssociationByTaskId(taskId);
	}
	@DeleteMapping("/Ticket/{ticketId}/task/{taskId}")
	public void deleteAsociationsWithTask(@PathVariable long taskId,@PathVariable long ticketId){
		ticketAssociationService.deleteTaskTicketAssociationBy(ticketId,taskId);
	}
	/* Pedir asociaciones de un ticket_id */
	@GetMapping("/Ticket/{ticketId}/Task")
	public Collection<TaskTicketAssociation> getTasks(@PathVariable long ticketId){
		return ticketAssociationService.findTasksTicketAssociationsByTicketId(ticketId);
	}
	/* Pedir asociaciones a una task en concreto */
	@GetMapping("/Ticket/Task/{taskId}")
	public Collection<TaskTicketAssociation> getTickets(@PathVariable long taskId){
		return ticketAssociationService.findTaskTicketAssociationsByTaskId(taskId);
	}
	/* Pedir Recursos */
	@GetMapping("/Recursos")
	public Collection<Recurso> getRecursos() {
		ApiRecursos recursos = new ApiRecursos();
		return recursos.getRecursos();
	}
	/* Pedir un recurso */
	@GetMapping("/Recursos/{legajo}")
	public Optional<Recurso> getRecurso(@PathVariable long legajo) {
		ApiRecursos recursos = new ApiRecursos();
		return recursos.findByLegajo(legajo);
	}
	/* Pedir Clientes */
	@GetMapping("/Clientes")
	public Collection<Cliente> getClientes() {
		ApiClientes clientes = new ApiClientes();
		return clientes.getClientes();
	}
	/* Pedir un cliente */
	@GetMapping("/Clientes/{id}")
	public Optional<Cliente> getCliente(@PathVariable long id) {
		ApiClientes clientes = new ApiClientes();
		return clientes.findById(id);
	}
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.build();
	}
}
