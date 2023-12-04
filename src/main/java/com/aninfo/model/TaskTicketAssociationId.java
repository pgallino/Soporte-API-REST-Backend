package com.aninfo.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/* Referencias
- https://stackoverflow.com/questions/60414409/spring-jpa-composite-key-this-class-does-not-define-an-idclass
- https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#identifiers-composite
 */
@Embeddable
public class TaskTicketAssociationId implements Serializable {
    private Long taskId;
    private Long ticketId;

    private TaskTicketAssociationId() {

    }
    public TaskTicketAssociationId(Long taskId, Long ticketId) {
        this.taskId = taskId;
        this.ticketId = ticketId;
    }
    public Long getTaskId() {
        return taskId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTaskId(Long task_id) {
        this.taskId = task_id;
    }

    public void setTicketId(Long ticket_id) {
        this.ticketId = ticket_id;
    }
}
