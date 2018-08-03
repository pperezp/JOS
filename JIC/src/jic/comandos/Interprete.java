package jic.comandos;

import jic.main.MainSystem;
import java.util.ArrayList;
import jic.argumentos.Argumento;

public class Interprete {

    private final ArrayList<Comando> comandos;
    private Comando ayuda;

    public Interprete() {
        this.comandos = new ArrayList<>();
        loadCommands();
    }

    /**
     * Éste es el método principal del Interprete. Es el que interpreta lo que
     * el usuario escribe
     *
     * @param lineaComando Es la linea completa que el usuario ingresa
     * incluyendo los argumentos
     */
    public void ejecutar(String lineaComando) {
        try {
            // Si existe dudas de porque llamé a este método, ver la 
            // Documentación del mismo.
            String[] argumentos = Argumento.getArgumentos(lineaComando);
            
            // El argumento 0 es el nombre del comando
            Comando comandoActual = getComando(argumentos[0]);

            // Si el comando no existe
            if (comandoActual == null) {
                System.out.println("\"" + argumentos[0] + "\" no se reconoce como un comando interno del sistema.");
                System.out.println("Intente con " + ayuda.getNombres());
            } else {
                comandoActual.ejecutar(argumentos);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error de escritura de comando.");
            System.out.println("Intente con " + ayuda.getNombres());
        }
        
    }

    /*ACÁ CREAR TODOS LOS COMANDOS!*/
    private void loadCommands() {
        ayuda = new Comando("help", "ayuda", "h")
                .setDescripcion("Muestra la ayuda del sistema")
                .setEjecucion((String[] argumentos) -> {
                    System.out.println("Lista de comandos disponibles:");
                    
                    for (Comando c : comandos) {
                        System.out.println(c.getNombres());
                        System.out.println("    " + c.getDescripcion());
                    }
        });
        this.comandos.add(ayuda);

        this.comandos.add(new Comando("exit", "salir")
                .setDescripcion("Sale del sistema")
                .setEjecucion((String[] argumentos) -> {
                    System.exit(0);
                })
        );

        this.comandos.add(new Comando("pwd")
                .setDescripcion("Ver la ruta actual")
                .setEjecucion((String[] argumentos) -> {
                    System.out.println(MainSystem.ruta);
                })
        );
        
        this.comandos.add(new Comando("prompt")
                .setDescripcion("Cambia el prompt actual del sistema")
                .setEjecucion((String[] argumentos) -> {
                    try {
                        MainSystem.prompt = argumentos[1];
                        System.out.println("El prompt se ha cambiado a "+argumentos[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        MainSystem.prompt = MainSystem.NOMBRE+":$ ";
                    }
                })
        );
    }

    public Comando getComando(String nombreComando) {
        for (Comando c : comandos) {
            if (c.isNombre(nombreComando)) {
                return c;
            }
        }
        return null;
    }
}
