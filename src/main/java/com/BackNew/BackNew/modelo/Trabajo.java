
package com.BackNew.BackNew.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trabajo")
public class Trabajo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;
    
    @Column(name = "puesto", length = 60, nullable = false)
    private String puesto;
    
    @Column(name = "descripcion", length = 600)
    private String descripcion;
    
    @Column(name = "referencia", length = 600)
    private String referencia;

    public Trabajo() {
    }

    public Trabajo(Long id, String nombre, String puesto, String descripcion, String referencia) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.referencia = referencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
}
