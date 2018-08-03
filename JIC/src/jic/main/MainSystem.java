package jic.main;

import java.util.Date;
import java.util.Scanner;
import jic.comandos.Comando;
import jic.comandos.Interprete;

public class MainSystem {
    public static String ruta = "/";
    private final String VERSION = "v0.1";
    public static final String NOMBRE  = "JIC";
    public static String prompt = MainSystem.NOMBRE+":$ ";
    
    private final Scanner scan;
    private final Interprete interprete;
    private String lineaComando;
    private Comando comandoActual;
    
    
    public MainSystem(){
        this.interprete = new Interprete();
        this.scan = new Scanner(System.in);
    }
    
    public void run(){
        System.out.println(NOMBRE+" - "+VERSION+" - "+new Date());
        
        while(true){
            System.out.print(prompt);
            lineaComando = scan.nextLine();
            interprete.ejecutar(lineaComando);
        }
    }
}
