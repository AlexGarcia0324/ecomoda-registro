package main.java.com.ecomoda.registro.session;

import main.java.com.ecomoda.registro.dto.UsuarioDTO;

public class SessionManager {

    private UsuarioDTO usuarioActual;

    public void iniciar(UsuarioDTO usuario) {
        this.usuarioActual = usuario;
    }

    public void cerrar() {
        this.usuarioActual = null;
    }

    public UsuarioDTO getUsuarioActual() {
        return usuarioActual;
    }
}