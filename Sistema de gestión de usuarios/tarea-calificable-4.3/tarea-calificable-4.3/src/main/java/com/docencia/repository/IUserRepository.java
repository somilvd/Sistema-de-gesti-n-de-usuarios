package com.docencia.repository;

import java.util.Set;

import com.docencia.model.Usuario;

public interface IUserRepository {

    /**
     * Funcion que realiza la busqueda de un email de un usuario
     * 
     * @param email String con el email normalizado
     * @return Usuario/null
     */
    public Usuario findByEmail(String email);

    /**
     * Funcion que determina si existe un email dentro del conjunto de usuarios
     * 
     * @param email String con el email normalizado
     * @return true/false
     */
    public boolean existsByEmail(String email);

    /**
     * Funcion que almacena un usuario en el repositorio
     * @param usuario El objeto usuario relleno
     */
    void save(Usuario usuario);

    /**
     * Funcion que retorna todos los elmentos del repositorios
     * @return Set de usuarios
     */

    Set<Usuario> findAll();

    /**
     * Funcion que permite eliminar un usuario por su email
     * @param email String con el email normalizado
     * @return Mensaje: Eliminado.
     */
    boolean deleteByEmail(String email);
}
