package com.aninfo.service;


import com.aninfo.model.TaskTicketAssociation;
import com.aninfo.repository.TaskTicketAssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/*
Referencias:
- https://docs.spring.io/spring-framework/reference/data-access/transaction/declarative/annotations.html
 */
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
    public Collection<TaskTicketAssociation> findTaskTicketAssociationsByTaskId(Long taskId) {
        return taskTicketAssociationRepository.findTaskTicketAssociationsByTaskId(taskId);
    }

    @Transactional // No funciona sin esto
    public void deleteTaskTicketAssociationBy(Long ticket_id, Long task_id) {
        taskTicketAssociationRepository.deleteTaskTicketAssociationByTicketIdAndTaskId(ticket_id, task_id);
    }
    @Transactional // No funciona sin esto
    public void deleteTaskTicketAssociationByTicketId(Long ticket_id) {
        taskTicketAssociationRepository.deleteTaskTicketAssociationByTicketId(ticket_id);
    }
    @Transactional
    public void deleteTaskTicketAssociationByTaskId(Long task_id) {
        taskTicketAssociationRepository.deleteTaskTicketAssociationByTaskId(task_id);
    }
}
