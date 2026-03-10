package com.docencia.repository.impl;

import java.util.HashSet;
import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.util.Validaciones;

public class UserRepositoryImpl implements IUserRepository{

    final Set<Usuario> usuarios;

    public UserRepositoryImpl() {
        this.usuarios = new HashSet<>();
    }

    @Override
    public Usuario findByEmail(String email) {
        email = Validaciones.normalizarEmail(email);
        if (!existsByEmail(email)) {
            return null;
        }
        Usuario usuarioBuscar = new Usuario(email);
        for (Usuario usuario : usuarios) {
            if (usuario.equals(usuarioBuscar)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        Usuario usuarioBuscar = new Usuario(email);
        return usuarios.contains(usuarioBuscar);
    }

    @Override
    public void save(Usuario usuario) {
        if (existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El email ya existe");
        }
        usuarios.add(usuario);
    }

    @Override
    public Set<Usuario> findAll() {
        return usuarios;
    }

    @Override
    public boolean deleteByEmail(String email) {
        if (!existsByEmail(email)) {
            return false;
        }
        return usuarios.remove(new Usuario(email));
    }
}
