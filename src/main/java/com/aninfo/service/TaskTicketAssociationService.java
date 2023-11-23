package com.aninfo.service;


import com.aninfo.model.TaskTicketAssociation;
import com.aninfo.repository.TaskTicketAssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class TaskTicketAssociationService {
    @Autowired
    private TaskTicketAssociationRepository taskTicketAssociationRepository;

    public TaskTicketAssociation createTaskTicketAssociation(TaskTicketAssociation association) {
        return taskTicketAssociationRepository.save(association);
    }

    public Collection<TaskTicketAssociation> findTasksTicketAssociationsByTicketId(Long ticket_id) {
        return taskTicketAssociationRepository.findTaskTicketAssociationsByTicketId(ticket_id);
    }

    @Transactional
    public void deleteTaskTicketAssociation(Long ticket_id, Long task_id) {
        taskTicketAssociationRepository.deleteTaskTicketAssociationByTicketIdAndTaskId(ticket_id, task_id);
    }
}
