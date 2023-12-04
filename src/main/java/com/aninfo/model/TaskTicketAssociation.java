package com.aninfo.model;

import javax.persistence.*;

@Entity
@IdClass(TaskTicketAssociationId.class)
public class TaskTicketAssociation {
    @Id
    private Long taskId;
    @Id
    private Long ticketId;
    public TaskTicketAssociation() {
    }

    public TaskTicketAssociation(Long task_id, Long ticket_id) {
        this.taskId = task_id;
        this.ticketId = ticket_id;
    }
    public Long getTaskId(){return taskId;}
    public Long getTicketId(){return ticketId;}
    public void setTaskId(Long task_id){this.taskId = task_id;}
    public void setTicketId(Long ticket_id){this.ticketId = ticket_id;}
}
