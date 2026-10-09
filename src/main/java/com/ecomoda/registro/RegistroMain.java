package main.java.com.ecomoda.registro;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.com.ecomoda.registro.config.DatabaseConnection;
import main.java.com.ecomoda.registro.controller.InventarioController;
import main.java.com.ecomoda.registro.controller.LoginController;
import main.java.com.ecomoda.registro.controller.RegistroController;
import main.java.com.ecomoda.registro.exception.ViewLoadException;
import main.java.com.ecomoda.registro.navigation.SceneManager;
import main.java.com.ecomoda.registro.navigation.View;
import main.java.com.ecomoda.registro.repository.AspiranteRepository;
import main.java.com.ecomoda.registro.repository.RolRepository;
import main.java.com.ecomoda.registro.repository.UsuarioRepository;
import main.java.com.ecomoda.registro.repository.jdbc.AspiranteRepositoryJdbc;
import main.java.com.ecomoda.registro.repository.jdbc.RolRepositoryJdbc;
import main.java.com.ecomoda.registro.repository.jdbc.UsuarioRepositoryJdbc;
import main.java.com.ecomoda.registro.service.AspiranteService;
import main.java.com.ecomoda.registro.service.AspiranteServiceImpl;
import main.java.com.ecomoda.registro.service.AuthService;
import main.java.com.ecomoda.registro.service.AuthServiceImpl;
import main.java.com.ecomoda.registro.session.SessionManager;
import main.java.com.ecomoda.registro.util.ErrorHandler;

public class RegistroMain extends Application {

    @Override
    public void start(Stage stage) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        UsuarioRepository usuarioRepository = new UsuarioRepositoryJdbc(databaseConnection);
        RolRepository rolRepository = new RolRepositoryJdbc(databaseConnection);
        AspiranteRepository aspiranteRepository = new AspiranteRepositoryJdbc(databaseConnection);

        AuthService authService = new AuthServiceImpl(usuarioRepository, rolRepository);
        AspiranteService aspiranteService = new AspiranteServiceImpl(aspiranteRepository);

        SessionManager sessionManager = new SessionManager();
        SceneManager sceneManager = new SceneManager(stage);

        sceneManager.register(View.LOGIN,
                () -> new LoginController(authService, sceneManager, sessionManager));
        sceneManager.register(View.REGISTRO,
                () -> new RegistroController(authService, sceneManager));
        sceneManager.register(View.INVENTARIO,
                () -> new InventarioController(aspiranteService, sceneManager, sessionManager));

        try {
            sceneManager.navigateTo(View.LOGIN);
        } catch (ViewLoadException e) {
            ErrorHandler.manejar(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}