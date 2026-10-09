package main.java.com.ecomoda.registro.repository;

import main.java.com.ecomoda.registro.model.Aspirante;
import java.util.List;

public interface AspiranteRepository {

    List<Aspirante> findAll();
    void save(Aspirante aspirante);
    void update(Aspirante aspirante);
    void deleteById(int id);
    boolean existsByCorreo(String correo, int excludedId);
}