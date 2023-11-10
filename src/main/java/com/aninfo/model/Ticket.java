package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String state;
    private String severity;
    private String client;
    public Ticket(){
    }

    public Ticket(String state, String severity, String client) {
        this.state = state;
        this.severity = severity;
        this.client = client;
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
    public String getClient() {
        return this.client;
    }

    public void setState(String state) {
        this.state = state;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public void setClient(String client) {
        this.client = client;
    }

}
