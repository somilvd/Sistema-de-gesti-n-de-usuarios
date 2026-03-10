package com.docencia.service.impl;

import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.repository.impl.UserRepositoryImpl;
import com.docencia.service.IUserService;
import com.docencia.util.Validaciones;

public class UserServiceImpl implements IUserService{

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Usuario crearUsuario(int id, String nombre, String email, String password) {

        Validaciones.validarNombre(nombre);
        Validaciones.validarEmail(email);
        Validaciones.validarPassword(password);

        email = Validaciones.normalizarEmail(email);

        Usuario usuario = new Usuario(id, email, password, nombre);
        userRepository.save(usuario);

        return usuario;
    }

    @Override
    public Set<Usuario> listarUsuarios() {
        
        return userRepository.findAll();
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        if (!Validaciones.emailValido(email)) {
            return null;
        }
        email = Validaciones.normalizarEmail(email);
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean eliminarPorEmail(String email) {
        if (!Validaciones.emailValido(email)) {
            return false;
        }
        email = Validaciones.normalizarEmail(email);
        return userRepository.deleteByEmail(email);
    }

    @Override
    public Usuario cambiarNombre(String email, String nuevoNombre) {
        Validaciones.validarNombre(nuevoNombre);

        Usuario usuario = userRepository.findByEmail(email);

        if (usuario == null) {
            return null;
        }

        usuario.setNombre(nuevoNombre);
        return usuario;
    }

    @Override
    public Usuario cambiarPassword(String email, String nuevaPassword) {

        Validaciones.validarPassword(nuevaPassword);

        Usuario usuario = userRepository.findByEmail(email);

        if (usuario == null) {
            return null;
        }
        
        usuario.setPassword(nuevaPassword);
        return usuario;
    }

}
