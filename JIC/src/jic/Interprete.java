package jic;

import java.util.ArrayList;

public class Interprete {
    private final ArrayList<Comando> comandos;

    public Interprete() {
        this.comandos = new ArrayList<>();
        loadCommands();
    }

    private void loadCommands() {
        this.comandos.add(new Comando("help").setDescripcion("Muestra la ayuda del sistema"));
        this.comandos.add(new Comando("exit").setDescripcion("Sale del sistema"));
        this.comandos.add(new Comando("pwd").setDescripcion("Ver la ruta actual"));
    }
    
    public Comando existeComando(String comando){
        for (Comando c : comandos) {
            if(c.getNombre().equals(comando)){
                return c;
            }
        }
        return null;
    }
}
