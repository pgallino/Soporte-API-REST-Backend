package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long productId;

    private long versionId;
    private String state;
    private String severity;
    private String client;

    public Ticket(){
    }

    public Ticket(String state, String severity, String client,long productId,long versionID) {
        this.state = state;
        this.severity = severity;
        this.client = client;
        this.productId = productId;
        this.versionId = versionID;
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
    public long getversionId() {
        return this.versionId;
    }
    public long getproductId() {
        return this.productId;
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
    public void setProductId(long productId) { this.productId = productId;}
    public void setversionId(long versionId) { this.versionId = versionId;}

    public void update(Ticket another){
        this.state = another.state;
        this.severity = another.severity;
    }

}
