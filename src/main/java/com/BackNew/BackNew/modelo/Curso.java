
package com.BackNew.BackNew.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre",length = 60, nullable = false)
    private String nombre;
    
    @Column(name = "institucion",length = 60, nullable = false)
    private String institucion;
    
    @Column(name = "descripcion",length = 600)
    private String descripcion;
    
    @Column(name = "link",length = 600)
    private String link;

    public Curso() {
    }

    public Curso(Long id, String nombre, String institucion, String descripcion, String link) {
        this.id = id;
        this.nombre = nombre;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.link = link;
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

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
