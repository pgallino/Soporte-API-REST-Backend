package com.aninfo.repository;

import com.aninfo.model.TaskTicketAssociation;
import com.aninfo.model.TaskTicketAssociationId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/* Referencias
- https://stackoverflow.com/questions/60414409/spring-jpa-composite-key-this-class-does-not-define-an-idclass
- https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#identifiers-composite
 */

@RepositoryRestResource
public interface TaskTicketAssociationRepository extends CrudRepository<TaskTicketAssociation, TaskTicketAssociationId> {
    List<TaskTicketAssociation> findTaskTicketAssociationByTicketId(Long ticket_id);
    List<TaskTicketAssociation> findTaskTicketAssociationByTaskId(Long task_id);

    @Override
    List<TaskTicketAssociation> findAll();
}
