package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;

import com.docencia.util.Validaciones;

public abstract class Persona {
    protected final int id;
    protected String nombre;


    protected Persona(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id inválido");
        }
        this.id = id;
    }

    protected Persona(int id, String nombre) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id inválido");
        }
        Validaciones.validarNombre(nombre);
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        Validaciones.validarNombre(nombre);
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }
    
}
