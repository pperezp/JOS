package jic;

import java.util.Date;
import java.util.Scanner;

public class MainSystem {
    public static String ruta = "/";
    private final String VERSION = "v0.1";
    private final String NOMBRE  = "JIC";
    private String prompt = NOMBRE+":$ ";
    
    private Scanner scan;
    private Interprete interprete;
    private String lineaComando;
    private Comando comandoActual;
    
    
    public MainSystem(){
        this.interprete = new Interprete();
        this.scan = new Scanner(System.in);
    }
    
    public void run(){
        System.out.println(NOMBRE+" - "+VERSION);
        System.out.println(new Date());
        
        while(true){
            System.out.print(prompt);
            lineaComando = scan.nextLine();
            interprete.ejecutar(lineaComando);
        }
    }
}
