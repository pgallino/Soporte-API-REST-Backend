package com.aninfo.model;
import javax.persistence.*;
import com.google.gson.annotations.SerializedName;
public class Cliente {
    @Id
    long id;
    @SerializedName("razon social")
    private String RazonSocial;
    private String CUIT;

    public Cliente(){}
    public void setId(long id) { this.id = id;}
    public void setRazonSocial(String razonsocial) { this.RazonSocial = razonsocial;}
    public void setCUIT(String CUIT) {this.CUIT = CUIT;}
    public long getId(){ return this.id;}
    public String getRazonSocial() { return this.RazonSocial;}
    public String getCUIT() {return this.CUIT;}
}
