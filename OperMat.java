package opermat;

import java.util.Scanner;
import opermat.Receptor;
import sun.audio.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bárbara Gutiérrez
 */
public class OperMat { 

    /**
     *
     */
    /**
     */
    @SuppressWarnings("empty-statement")
   
   
    
    public static Map<String,ArrayList<String>> dic=new HashMap<>();
    public static Map<String,ArrayList<ArrayList<Integer>>> dicaux=new HashMap<>();
    

    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {;
        String sonido="ta-da.wav";
        InputStream in=new FileInputStream(sonido);
        AudioStream audio=new AudioStream(in);
        AudioPlayer.player.start(audio);
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println((char)27 + "[34mIngrese el comando:" + (char)27 + "[0m");
        input=(scanner.nextLine());
        String entrada[] = input.split(" ");
        String input2 = input;
        input=entrada[0];
        String[] datos = Arrays.copyOfRange(entrada, 1, entrada.length); 
        while (!"fin".equals(input)){
            if ("finalizar".equals(input)){
                if (entrada.length!=1){
                    System.out.println((char)27 + "[31mEl comando ingresado no existe" + (char)27 + "[0m"); 
                    String[] arguments = new String[] {""};
                    OperMat.main(arguments);
                    break;
                }
            else{
                    System.out.println((char)27 + "[31m¿Esta seguro que desea salir?" + (char)27 + "[0m");    
                    Scanner salirScanner = new Scanner(System.in);
                    String salir;
                    salir=(salirScanner.next());
                    if ("si".equals(salir)){
                        System.out.println((char)27 + "[34mGracias por usar esta aplicación" + (char)27 + "[0m");
                        break;
                    }
                    else {
                        String[] arguments = new String[] {""};
                        OperMat.main(arguments);
                        break;
                    }
                }
            } else {
                Receptor miReceptor;
                miReceptor=new Receptor();
                miReceptor.Recibir(input,datos,dic); 
                String[] arguments = new String[] {""};
                OperMat.main(arguments);
                break;
            }
        }
        if ("fin".equals(input)) {
            if (entrada.length==1){
            System.out.println((char)27 + "[31m¿Esta seguro que desea salir?" + (char)27 + "[0m");
            Scanner salirScanner = new Scanner(System.in);
            String salir;
            salir=(salirScanner.next());   
            if ("si".equals(salir)){
              System.out.println((char)27 + "[34mGracias por usar esta aplicación" + (char)27 + "[0m");   
                }
            else {
                String[] arguments = new String[] {""};
                OperMat.main(arguments);
            }
            } else {
                  if (entrada.length!=1){
                    System.out.println((char)27 + "[31mEl comando ingresado no existe" + (char)27 + "[0m"); 
                    String[] arguments = new String[] {""};
                    OperMat.main(arguments);
                }
            }
        }
    }  
}
