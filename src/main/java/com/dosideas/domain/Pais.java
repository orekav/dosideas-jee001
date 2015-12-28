package com.dosideas.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Este objeto de dominio utiliza anotaciones para relacionar la clase y sus
 * atributos con una tabla. Hibernate utiliza estas anotaciones para acceder
 * a la base de datos e interactuar con objetos de esta clase.
 *
 * @author ldeseta
 */
@Entity
public class Pais implements Serializable {

    @Id
    private Long id;

    @Column
    private String nombre;

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
}
