package com.docencia.service.impl;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.repository.impl.UserRepositoryImpl;
import com.docencia.service.IAuthService;
import com.docencia.util.Validaciones;

public class AuthServiceImpl implements IAuthService {

    final IUserRepository userRepository;

    public AuthServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Usuario register(int id, String nombre, String email, String password) {

        Validaciones.validarNombre(nombre);
        Validaciones.validarEmail(email);
        Validaciones.validarPassword(password);

        email = Validaciones.normalizarEmail(email);

        if (id < 1 || !Validaciones.emailValido(email) || !Validaciones.passwordValida(password)) {
            return null;
        }

        Usuario usuario = new Usuario(id, email, password, nombre);
        userRepository.save(usuario);

        return usuario;
    }

    @Override
    public boolean login(String email, String password) {

        email = Validaciones.normalizarEmail(email);

        Usuario usuario = userRepository.findByEmail(email);

        if (usuario == null) {
            return false;
        }

        if (usuario.isBloqueado()) {
            return false;
        }

        if (usuario.getPassword().equals(password)) {
            usuario.resetearIntentosFallidos();
            return true;
        }

        usuario.incrementarIntentosFallidos();

        if (usuario.getIntentosFallidos() >= 3) {
            usuario.bloquear();
        }

        return false;
    }

    @Override
    public boolean isBloqueado(String email) {
        email = Validaciones.normalizarEmail(email);
        Usuario usuario = userRepository.findByEmail(email);
        return usuario != null && usuario.isBloqueado();
    }

    @Override
    public void desbloquear(String email) {
        email = Validaciones.normalizarEmail(email);
        Usuario usuario = userRepository.findByEmail(email);
        if (usuario != null) {
            usuario.resetearIntentosFallidos();
        }
    }

}
