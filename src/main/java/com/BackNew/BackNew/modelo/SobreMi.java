
package com.BackNew.BackNew.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SobreMi")
public class SobreMi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "titulo", length = 600, nullable=false)
    private String titulo;
    
    @Column(name = "descripcion", length =20000, nullable=false)
    private String descripcion;

    public SobreMi() {
    }

    public SobreMi(Long id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
