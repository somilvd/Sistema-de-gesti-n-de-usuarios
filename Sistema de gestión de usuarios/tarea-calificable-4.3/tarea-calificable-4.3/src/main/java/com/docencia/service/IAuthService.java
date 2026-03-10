package com.docencia.service;

import com.docencia.model.Usuario;

public interface IAuthService {

    /**
     * Funcion que permite registrar un usuario dentro del sistema
     * @param id Id del usuario
     * @param nombre Nombre del usuario
     * @param email Email del usuario
     * @param password Password del usuario
     * @return Usuario
     */
    Usuario register(int id, String nombre, String email, String password);

    /**
     * Funcion que permite que un usuario ya existente, inicie sesion en el sistema
     * @param email Email del usuario
     * @param password Password del usuario
     * @return Mensaje, true/false
     */
    boolean login(String email, String password);

    /**
     * Funcion que verifica si un usuario esta bloqueado
     * @param email Email del usuario
     * @return true/false
     */
    boolean isBloqueado(String email);

    /**
     * Funcion que permite desbloquear a un usuario bloqueado
     * @param email Email del usuario
     */
    void desbloquear(String email);
}