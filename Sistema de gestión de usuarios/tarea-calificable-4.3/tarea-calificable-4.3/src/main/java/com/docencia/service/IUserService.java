package com.docencia.service;

import java.util.Set;

import com.docencia.model.Usuario;

public interface IUserService {

    Usuario crearUsuario(int id, String nombre, String email, String password);

    Set<Usuario> listarUsuarios();

    /**
     * Funcion que retorna un usuario a traves de su email
     * @param email String con el email del usuario
     * @return Objeto de la clase usuario
     */
    Usuario buscarPorEmail(String email);

    /**
     * Funcion que elimina un usuario por email
     * @param email String con el email del usuario
     * @return true / false
     */
    boolean eliminarPorEmail(String email);

    /**
     * Funcion que permite cambiar el nombre de un usuario
     * @param email Email del usuario
     * @param nuevoNombre El nuevo nombre del usuario
     * @return Usuario con el nombre actualizado si se encontro, null si no existe
     */
    Usuario cambiarNombre(String email, String nuevoNombre);

    /**
     * Funcion que permite cambiar la contraseña de un usuario
     * @param email Email del usuario
     * @param nuevaPassword La nueva contraseña del usuario
     * @return Usuario actualizado si se encontro y la contraseña es valida, null si no existe o es invalida
     */
    Usuario cambiarPassword(String email, String nuevaPassword);

}
