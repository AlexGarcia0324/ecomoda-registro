package main.java.com.ecomoda.registro.repository;

import main.java.com.ecomoda.registro.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository {

    void save(Usuario usuario);

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    boolean existsByNombreUsuarioOrCorreo(String nombreUsuario, String correo);
}