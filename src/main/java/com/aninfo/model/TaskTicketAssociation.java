package com.aninfo.model;

import javax.persistence.*;

@Entity
public class TaskTicketAssociation {
    @Id
    private Long task_id;
    @Id
    private Long ticket_id;

    public TaskTicketAssociation(){
    }

    public TaskTicketAssociation(Long task_id, Long ticket_id) {
        this.task_id = task_id;
        this.ticket_id = ticket_id;
    }
    public Long getTaskId(){return task_id;}
    public Long getTicketId(){return ticket_id;}
    public void setTaskId(Long task_id){this.task_id = task_id;}
    public void setTicketId(Long ticket_id){this.ticket_id = ticket_id;}
}
