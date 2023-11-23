package com.aninfo;

import com.aninfo.model.TaskTicketAssociation;
import com.aninfo.model.Ticket;
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
	private TaskTicketAssociationService taskTicketAssociationService;

	public static void main(String[] args) {
		SpringApplication.run(SoporteApp.class, args);
	}

	/* END-POINTS */
	@PostMapping("/tickets")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);
	}

	@GetMapping("/tickets")
	public Collection<Ticket> getTickets() {
		return ticketService.getTickets();
	}

	@GetMapping("/tickets/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
		Optional<Ticket> ticketOptional = ticketService.findById(id);
		return ResponseEntity.of(ticketOptional);
	}

	@PutMapping("/tickets/{id}")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @PathVariable Long id) {
		Optional<Ticket> ticketOptional = ticketService.findById(id);

		if (!ticketOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		ticket.setId(id);
		ticketService.save(ticket);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/tickets/{id}")
	public void deleteTicket(@PathVariable Long id) {
		ticketService.deleteById(id);
	}

	@PostMapping("/associations")
	public TaskTicketAssociation createTaskTicketAssociation(@RequestBody TaskTicketAssociation taskTicketAssociation) {
		return taskTicketAssociationService.createTaskTicketAssociation(taskTicketAssociation);
	}
	@GetMapping("/tickets/{id}/tasks")
	public Collection<TaskTicketAssociation> getAssociatedTasks(@PathVariable Long id) {
		return taskTicketAssociationService.findTasksTicketAssociationsByTicketId(id);
	}

	@DeleteMapping("/tickets/{ticket_id}/tasks/{task_id}")
	public void deleteAssociatedTaskForTicket(@PathVariable Long ticket_id, @PathVariable Long task_id) {
		taskTicketAssociationService.deleteTaskTicketAssociation(ticket_id, task_id);
	}

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build();
	}
}
