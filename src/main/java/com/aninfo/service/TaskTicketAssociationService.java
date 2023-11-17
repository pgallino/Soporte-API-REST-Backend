package com.aninfo.service;


import com.aninfo.model.TaskTicketAssociation;
import com.aninfo.repository.TaskTicketAssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskTicketAssociationService {
    @Autowired
    private TaskTicketAssociationRepository taskTicketAssociationRepository;

    public TaskTicketAssociation createTaskTicketAssociation(TaskTicketAssociation association) {
        return taskTicketAssociationRepository.save(association);
    }

    public Collection<TaskTicketAssociation> findTasksAssociatedByTicket(Long ticket_id) {
        return taskTicketAssociationRepository.findTaskTicketAssociationByTicketId(ticket_id);
    }
}
