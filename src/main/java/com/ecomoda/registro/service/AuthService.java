package main.java.com.ecomoda.registro.service;

import main.java.com.ecomoda.registro.dto.LoginDTO;
import main.java.com.ecomoda.registro.dto.RegistroUsuarioDTO;
import main.java.com.ecomoda.registro.dto.RolDTO;
import main.java.com.ecomoda.registro.dto.UsuarioDTO;
import java.util.List;

public interface AuthService {

    UsuarioDTO login(LoginDTO loginDTO);

    void registrar(RegistroUsuarioDTO registroDTO);

    List<RolDTO> listarRoles();
}