package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    private Long id;
    private Long projectId;
    private String estado;
    private String fechaInicio;
    private String fechaFin;
    private String prioridad;
    private String asignado;
    private String titulo;

    private String descripcion;

    public Task(){
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    public void setAsignado(String asignado) {
        this.asignado = asignado;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Long getId() { return this.id;}
    public Long getProjectId() { return this.projectId;}
    public String getEstado() { return this.estado;}
    public String getFechaInicio() { return this.fechaInicio;}
    public String getFechaFin() { return this.fechaFin;}
    public String getPrioridad() { return this.prioridad;}
    public String getAsignado() { return this.asignado;}
    public String getT() { return this.titulo;}
    public String getDescripcion() { return this.descripcion;}
}
