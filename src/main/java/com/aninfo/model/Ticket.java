package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_ticket;
    private String descripcion;
    private String fecha_de_creacion;
    private String estado;
    private String severidad;

    private String prioridad;
    private long cliente;
    private long asignado;
    private String comentarios;
    private long producto_id;

    private long version_id;
    private String nombre;


    public Ticket(){
    }

    public Ticket(String descripcion, String fecha_de_creacion, String estado, String severidad, String prioridad, long cliente, long asignado, String comentarios, long producto_id, long version_id, String nombre) {
        this.descripcion = descripcion;
        this.fecha_de_creacion = fecha_de_creacion;
        this.estado = estado;
        this.severidad = severidad;
        this.prioridad = prioridad;
        this.cliente = cliente;
        this.asignado = asignado;
        this.comentarios = comentarios;
        this.producto_id = producto_id;
        this.version_id = version_id;
        this.nombre = nombre;

    }

    public Long getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(long id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getEstado() {
        return this.estado;
    }
    public String getSeveridad() {
        return this.severidad;
    }
    public long getCliente() {
        return this.cliente;
    }
    public long getAsignado() {
        return this.asignado;
    }
    public long getVersion_id() {
        return this.version_id;
    }
    public long getProducto_id() {
        return this.producto_id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public String getFecha_de_creacion() {
        return this.fecha_de_creacion;
    }
    public String getPrioridad() {
        return this.prioridad;
    }
    public String getComentarios() {
        return this.comentarios;
    }
    public String getNombre() { return this.nombre;}

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }
    public void setCliente(long cliente) {
        this.cliente = cliente;
    }
    public void setAsignado(long asignado) {
        this.asignado = asignado;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFecha_de_creacion(String fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public void setProducto_id(long producto_id) { this.producto_id = producto_id;}
    public void setVersion_id(long version_id) { this.version_id = version_id;}
    public void setNombre(String nombre) { this.nombre = nombre;}
    public void update(Ticket another){
        this.descripcion = another.descripcion;
        this.estado = another.estado;
        this.severidad = another.severidad;
        this.prioridad = another.prioridad;
        this.asignado = another.asignado;
        this.comentarios = another.comentarios;
    }

}
