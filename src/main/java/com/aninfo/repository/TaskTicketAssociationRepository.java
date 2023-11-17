package com.aninfo.repository;

import com.aninfo.model.TaskTicketAssociation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TaskTicketAssociationRepository extends CrudRepository<TaskTicketAssociation, Long> {
    List<TaskTicketAssociation> findTaskTicketAssociationByTicketId(Long ticket_id);
    List<TaskTicketAssociation> findTaskTicketAssociationByTaskId(Long task_id);

    @Override
    List<TaskTicketAssociation> findAll();
}
