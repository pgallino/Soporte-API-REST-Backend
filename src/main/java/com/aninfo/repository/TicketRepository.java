package com.aninfo.repository;

import com.aninfo.model.Ticket;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    @Override
    List<Ticket> findAll();
    Optional<Ticket> findTicketByid(long id);
}
