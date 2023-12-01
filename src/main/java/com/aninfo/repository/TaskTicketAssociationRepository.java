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
    List<TaskTicketAssociation> findTaskTicketAssociationsByTicketId(Long ticket_id);
    List<TaskTicketAssociation> findTaskTicketAssociationsByTaskId(Long task_id);

    void deleteTaskTicketAssociationByTicketIdAndTaskId(Long ticket_id, Long task_id);
    void deleteTaskTicketAssociationByTicketId(Long ticket_id);
    void deleteTaskTicketAssociationByTaskId(Long ticket_id);
    @Override
    List<TaskTicketAssociation> findAll();
}
