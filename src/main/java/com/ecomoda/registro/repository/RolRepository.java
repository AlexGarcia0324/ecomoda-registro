package main.java.com.ecomoda.registro.repository;

import main.java.com.ecomoda.registro.model.Rol;
import java.util.List;
import java.util.Optional;

public interface RolRepository {

    List<Rol> findAll();

    Optional<Rol> findById(int id);
}