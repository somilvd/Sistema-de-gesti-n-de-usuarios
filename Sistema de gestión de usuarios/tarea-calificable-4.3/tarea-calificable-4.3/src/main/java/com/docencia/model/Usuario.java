package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;

import com.docencia.util.Validaciones;

/**
 * @author SomilVD
 * @version 1.0.0
 */

public class Usuario extends Persona {
    private final String email;
    private String password;
    private int intentosFallidos;
    private boolean bloqueado;
    private final LocalDate fechaRegistro;

    public Usuario(int id) {
        super(id);
        email = null;
        fechaRegistro = null;
    }

    public Usuario(String email) {
        super(1);
        this.email = Validaciones.normalizarEmail(email);
        this.fechaRegistro = null;
    }

    public Usuario(int id, String email, String password, String nombre) {
        super(id, nombre);

        Validaciones.emailValido(email);
        Validaciones.validarPassword(password);

        this.email = Validaciones.normalizarEmail(email);
        this.password = password;
        this.intentosFallidos = 0;
        this.bloqueado = false;
        this.fechaRegistro = LocalDate.now();
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        Validaciones.validarPassword(password);
        this.password = password;
    }

    public int getIntentosFallidos() {
        return this.intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public boolean isBloqueado() {
        return this.bloqueado;
    }

    public boolean getBloqueado() {
        return this.bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void incrementarIntentosFallidos() {
        intentosFallidos++;
    }

    public void resetearIntentosFallidos() {
        intentosFallidos = 0;
    }

    public void bloquear() {
        bloqueado = true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "{ id = " + getId() + ", nombre= '" + getNombre() + "'" +
                " email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                ", intentosFallidos='" + getIntentosFallidos() + "'" +
                ", bloqueado='" + isBloqueado() + "'" +
                ", fechaRegistro='" + getFechaRegistro() + "'" +
                "}";
    }

}
