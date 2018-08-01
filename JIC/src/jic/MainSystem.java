package jic;

import java.util.Date;
import java.util.Scanner;

public class MainSystem {
    private final String VERSION = "v0.1";
    private final String NOMBRE  = "JIC";
    
    private Scanner scan;
    private Interprete interprete;
    private String ruta;
    private String lineaComando;
    private Comando comandoActual;
    
    
    public MainSystem(){
        this.interprete = new Interprete();
        this.ruta = "/";
        this.scan = new Scanner(System.in);
    }
    
    public void run(){
        System.out.println(NOMBRE+" - "+VERSION);
        System.out.println(new Date());
        String nombreComando;
        boolean salir = false;
        
        while(true){
            System.out.print(NOMBRE+"> ");
            lineaComando = scan.nextLine();
            nombreComando = lineaComando.split(" ")[0];
            
            comandoActual = interprete.existeComando(nombreComando);
            
            if(comandoActual == null){
                System.out.println("\""+nombreComando+"\" no se reconoce como un comando interno del sistema.");
            }else{
                // Comando válido
                switch(nombreComando){
                    case "exit":
                        salir = true;
                        break;
                        
                }
                
                if(salir){
                    break;
                }
            }
        }
    }
}
