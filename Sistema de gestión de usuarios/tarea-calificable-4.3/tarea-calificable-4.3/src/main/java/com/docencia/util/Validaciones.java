package com.docencia.util;

public class Validaciones {
    public static String normalizarEmail(String email) {
        if (email == null || email.isBlank()) {
            return null;
        }
        return email.trim().toLowerCase();
    }

    public static boolean emailValido(String email) {
        email = normalizarEmail(email);
        if (email == null) {
            return false;
        }
        return email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

    public static void validarEmail(String email) {
    if (!emailValido(email)) {
        throw new IllegalArgumentException("Email inválido");
    }
}

    public static boolean passwordValida(String password) {
        if (password == null || password.isBlank()) {
            return false;
        }
        if (password.length() < 7) {
            throw new IllegalArgumentException("La contraseña debe tener más de 6 caracteres");
        }
        return password.matches("^[a-zA-Z0-9\\.+_-]+$");
    }

    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return; 
        }
        if (nombre.length() < 5) {
            throw new IllegalArgumentException("El nombre debe tener más de 5 caracteres");
        }
    }

    public static void validarPassword(String password) {
        if (!passwordValida(password)) {
            throw new IllegalArgumentException("Contraseña inválida");
        }
    }

    
}
