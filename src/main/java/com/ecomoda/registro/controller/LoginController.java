package main.java.com.ecomoda.registro.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.com.ecomoda.registro.dto.LoginDTO;
import main.java.com.ecomoda.registro.dto.UsuarioDTO;
import main.java.com.ecomoda.registro.exception.AuthException;
import main.java.com.ecomoda.registro.exception.DataAccessException;
import main.java.com.ecomoda.registro.exception.ValidationException;
import main.java.com.ecomoda.registro.exception.ViewLoadException;
import main.java.com.ecomoda.registro.navigation.SceneManager;
import main.java.com.ecomoda.registro.navigation.View;
import main.java.com.ecomoda.registro.service.AuthService;
import main.java.com.ecomoda.registro.session.SessionManager;
import main.java.com.ecomoda.registro.util.ErrorHandler;

public class LoginController {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;

    private final AuthService authService;
    private final SceneManager sceneManager;
    private final SessionManager sessionManager;

    public LoginController(AuthService authService, SceneManager sceneManager, SessionManager sessionManager) {
        this.authService = authService;
        this.sceneManager = sceneManager;
        this.sessionManager = sessionManager;
    }

    @FXML
    private void iniciarSesion() {
        try {
            UsuarioDTO usuario = authService.login(new LoginDTO(txtUsuario.getText(), txtPassword.getText()));
            sessionManager.iniciar(usuario);
            sceneManager.navigateTo(View.INVENTARIO);
        } catch (ValidationException | AuthException | DataAccessException | ViewLoadException e) {
            ErrorHandler.manejar(e);
        }
    }

    @FXML
    private void irARegistro() {
        try {
            sceneManager.navigateTo(View.REGISTRO);
        } catch (ViewLoadException e) {
            ErrorHandler.manejar(e);
        }
    }
}