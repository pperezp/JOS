package jic;

import java.util.ArrayList;

public class Interprete {

    private final ArrayList<Comando> comandos;

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
        String nombreComando = lineaComando.split(" ")[0];
        Comando comandoActual = getComando(nombreComando);

        // Si el comando no existe
        if (comandoActual == null) {
            System.out.println("\"" + nombreComando + "\" no se reconoce como un comando interno del sistema.");
        } else {
            comandoActual.ejecutar();
        }
    }

    private void loadCommands() {
        this.comandos.add(new Comando("help", "ayuda", "h")
                .setDescripcion("Muestra la ayuda del sistema")
                .setEjecucion(() -> {
                    System.out.println("Lista de comandos disponibles:");
                    for (Comando c : comandos) {
                        System.out.print("\t| ");

                        for (String nombre : c.getNombres()) {
                            System.out.print(nombre + " | ");
                        }
                        System.out.println();
                        System.out.println("\t\t" + c.getDescripcion());
                    }
                })
        );

        this.comandos.add(new Comando("exit", "salir")
                .setDescripcion("Sale del sistema")
                .setEjecucion(() -> {
                    System.exit(0);
                })
        );

        this.comandos.add(new Comando("pwd")
                .setDescripcion("Ver la ruta actual")
                .setEjecucion(() -> {
                    System.out.println(MainSystem.ruta);
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
