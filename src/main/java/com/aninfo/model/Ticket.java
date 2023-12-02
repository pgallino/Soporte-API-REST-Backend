package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String date;
    private String state;
    private String severity;

    private String priority;
    private long client;
    private long assigned;
    private String comment;
    private long productId;

    private long versionId;



    public Ticket(){
    }

    public Ticket(String description, String date, String state, String severity, String priority, long client, long assigned, String comment, long productId, long versionId) {
        this.description = description;
        this.date = date;
        this.state = state;
        this.severity = severity;
        this.priority = priority;
        this.client = client;
        this.assigned = assigned;
        this.comment = comment;
        this.productId = productId;
        this.versionId = versionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return this.state;
    }
    public String getSeverity() {
        return this.severity;
    }
    public long getClient() {
        return this.client;
    }
    public long getAssigned() {
        return this.assigned;
    }
    public long getversionId() {
        return this.versionId;
    }
    public long getproductId() {
        return this.productId;
    }
    public String getDescription() {
        return this.description;
    }
    public String getDate() {
        return this.date;
    }
    public String getPriority() {
        return this.priority;
    }
    public String getComment() {
        return this.comment;
    }

    public void setState(String state) {
        this.state = state;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public void setClient(long client) {
        this.client = client;
    }
    public void setAssigned(long assigned) {
        this.assigned = assigned;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setProductId(long productId) { this.productId = productId;}
    public void setversionId(long versionId) { this.versionId = versionId;}

    public void update(Ticket another){
        this.description = another.description;
        this.state = another.state;
        this.severity = another.severity;
        this.priority = another.priority;
        this.assigned = another.assigned;
        this.comment = another.comment;
    }

}
