package main.java.com.ecomoda.registro.service;

import main.java.com.ecomoda.registro.dto.AspiranteDTO;
import java.util.List;

public interface AspiranteService {

    List<AspiranteDTO> listar();

    void agregar(AspiranteDTO aspiranteDTO);

    void actualizar(AspiranteDTO aspiranteDTO);

    void eliminar(int id);
}