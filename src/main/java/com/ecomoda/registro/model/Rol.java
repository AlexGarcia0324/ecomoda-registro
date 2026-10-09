
package main.java.com.ecomoda.registro.model;

public class Rol {

    private int id;
    private String nombre;

    public Rol(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}