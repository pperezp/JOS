package jic;

import java.util.ArrayList;

public class Comando {
    private String nombre;
    private ArrayList<String> argumentos;
    private String descripcion;

    public Comando() {
    }

    public Comando(String nombre) {
        this.nombre = nombre;
        this.argumentos = new ArrayList<>();
    }

    public Comando addArgumento(String arg){
        this.argumentos.add(arg);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getArgumentos() {
        return argumentos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Comando setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
    
    
}
