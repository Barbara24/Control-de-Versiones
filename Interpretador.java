package opermat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import opermat.Matriz;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Interpretador {
    public String comando;
    public String[] datos; 
    private final Impresor miImpresor;
    
    public Interpretador(){
      miImpresor=new Impresor();    
    }
    
    /**
     *
     * @param comando
     * @param datos
     */
    public void AcercaDe(String comando,String[] datos){
        if (datos.length==0){
        String mensaje= "Opermat(Operaciones sobre matrices)\nVersión:1.0\nFecha de Creación: 2017\nAutor: Bárbara Gutiérrez Quirós ";
        //miImpresor=new Impresor();
        miImpresor.ImprimirAcercaDe(mensaje);
        }
        else{
          System.out.println((char)27 + "[31mEl comando ingresado no existe" + (char)27 + "[0m");
            
        }
           
    }
    
    /**
     *
     * @param comando
     * @param datos
     */
    public void Mae(String comando,String[]datos){
        if (datos.length==4){
            System.out.println(datos[0]);
            int filas=Integer.parseInt(datos[1]);
            int columnas=Integer.parseInt(datos[3]);
            ArrayList<ArrayList<Integer>> resultado;
            resultado = new ArrayList<>();
            while (filas!=0){
                ArrayList<Integer> listaxfilas;
                listaxfilas = new ArrayList<>();
                Random random = new Random();
                int i;
                for (i=0;i<columnas;i++){
                    int randomInteger = random.nextInt();
                    listaxfilas.add(randomInteger);
                }
            resultado.add(listaxfilas);
            filas--;
            }
            miImpresor.ImprimirMae(resultado);
        }
        else{
           System.out.println((char)27 + "[31mEl comando ingresado no existe" + (char)27 + "[0m"); 
        }
        

        
    }
    
    /**
     *
     * @param comando
     * @param datos
     */
    public void Maf(String comando, String[]datos){
        if (datos.length==4){
            System.out.println(datos[0]);
            int filas=Integer.parseInt(datos[1]);
            int columnas=Integer.parseInt(datos[3]);
            ArrayList<ArrayList<Double>> resultado;
            resultado = new ArrayList<>();
            while (filas!=0){
                ArrayList<Double> listaxfilas;
                listaxfilas = new ArrayList<>();
                Random random = new Random();
                int i;
                for (i=0;i<columnas;i++){
                    double randomDouble = random.nextInt();
                    listaxfilas.add(randomDouble);
                }
            resultado.add(listaxfilas);
            filas--;
            }
            miImpresor.ImprimirMaf(resultado);
        }
        else{
           System.out.println((char)27 + "[31mEl comando ingresado no existe" + (char)27 + "[0m"); 
        }  
    }
    
    /**
     *
     * @param comando
     * @param datos
     * @param dic
     */
    public void Lee(String comando,String[]datos,Map<String,ArrayList<String>> dic){
        if (".".equals(datos[(datos.length-1)])){
            ArrayList<String> datosf;
            datosf=new ArrayList<>();
            int i;
            for (i=1;i<(datos.length-1);i++){
                datosf.add(datos[i]);
            }
            Matriz miMatriz;
            miMatriz=new Matriz();
            miMatriz.CrearMatriz(datos[0],datosf,dic,datos);
        }
        else{
           System.out.println((char)27 + "[31mEl comando ingresado no existe, su matriz se termina donde aparezce un '.'" + (char)27 + "[0m"); 
        }
    }
    
    public void Asignar(String comando,String[]datos,Map<String,ArrayList<String>> dic){
        if (".".equals(datos[(datos.length-1)])){
            ArrayList<String> datosf;
            datosf=new ArrayList<>();
            int i;
            for (i=1;i<(datos.length-1);i++){
                datosf.add(datos[i]);
            }
            Matriz miMatriz;
            miMatriz=new Matriz();
            miMatriz.Asignar(comando, datosf, dic, datos);
        }
        else{
           System.out.println((char)27 + "[31mEl comando ingresado no existe, su matriz se termina donde aparezce un '.'" + (char)27 + "[0m"); 
        }
    }
    
    /**
     *
     * @param comando
     * @param dic
     */
    public void Desplegar(String comando,Map<String,ArrayList<String>> dic){
            Matriz miMatriz;
            miMatriz=new Matriz();
            miMatriz.Encontrarvalores(comando, dic);
    }
    
    
    public void sumarMatriz(String[] datos,Map<String,ArrayList<String>> dic ){
        if (datos.length==2){
            Matriz miMatriz;
            miMatriz=new Matriz();
            miMatriz.sumaMatriz(datos, dic);
        }
        else{
            System.out.println((char)27 + "[31mEl comando ingresado no existe, con esta función solo se suman dos matrices" + (char)27 + "[0m");
        }
    }
    
    public void restarMatriz(String[] datos,Map<String,ArrayList<String>> dic){
        if (datos.length==2){
            Matriz miMatriz;
            miMatriz=new Matriz();
            miMatriz.restaMatriz(datos, dic);
        }
        else{
            System.out.println((char)27 + "[31mEl comando ingresado no existe, con esta función solo se suman dos matrices" + (char)27 + "[0m");
        } 
    }
    
    public void multiplicarMatriz(String[] datos,Map<String,ArrayList<String>> dic){
        if (datos.length==2){
            Matriz miMatriz;
            miMatriz=new Matriz();
            miMatriz.multiplicaMatriz(datos, dic);
        }
        else{
            System.out.println((char)27 + "[31mEl comando ingresado no existe, con esta función solo se suman dos matrices" + (char)27 + "[0m");
        }  
    }
    
    public void exponenciarMatriz (String[] datos,Map<String,ArrayList<String>> dic){
        if (datos.length==2){
            Matriz miMatriz;
            miMatriz=new Matriz();
            miMatriz.exponenciacionMatriz(datos, dic);
        }
        else{
            System.out.println((char)27 + "[31mEl comando ingresado no existe, con esta función solo se suman dos matrices" + (char)27 + "[0m");
        }
    }
    
    public void Programador(String[] datos,Map<String,ArrayList<String>> dic){
        if (datos.length==2){
            if (dic.containsKey(datos[0])){
                Matriz miMatriz;
                miMatriz=new Matriz();
                if ("ascendente".equals(datos[1])){
                    miMatriz.ascendenteMatriz(datos, dic);
                }
                else if("asc".equals(datos[1])){
                    miMatriz.ascendenteMatriz(datos, dic);
                }
                else if("descendente".equals(datos[1])){
                    miMatriz.descendenteMatriz(datos, dic);
                }
                else if("desc".equals(datos[1])){
                    miMatriz.descendenteMatriz(datos, dic);
                }
                else{
                  System.out.println((char)27 + "[31mLa forma en la que se desea hacer el ordenamiento no existe" + (char)27 + "[0m");  
                }
            }
            else{
               System.out.println((char)27 + "[31mLa matriz\t" + datos[0] +"\tno existe" + (char)27 + "[0m"); 
            }
            
        }
        else{
          System.out.println((char)27 + "[31mEl comando ingresado no existe" + (char)27 + "[0m");  
        }
    }
    
    /**
     *
     * @param datos
     * @param dic
     * @param dicaux
     */
    public void InfPost(String datos,Map<String,ArrayList<String>> dic, Map<String,ArrayList<ArrayList<Integer>>> dicaux){
    String expr = depurar(datos);
    String[] arrayInfix = expr.split(" ");

    //Declaración de las pilas
    Stack < String > E = new Stack <  > (); //Pila entrada
    Stack < String > P = new Stack <  > (); //Pila temporal para operadores
    Stack < String > S = new Stack <  > (); //Pila salida

    //Añadir la array a la Pila de entrada (E)
    for (int i = arrayInfix.length - 1; i >= 0; i--) {
      E.push(arrayInfix[i]);
    }

    try {
      //Algoritmo Infijo a Postfijo
      while (!E.isEmpty()) {
        switch (pref(E.peek())){
          case 1:
            P.push(E.pop());
            break;
          case 3:
          case 4:
            while(pref(P.peek()) >= pref(E.peek())) {
              S.push(P.pop());
            }
            P.push(E.pop());
            break; 
          case 2:
            while(!P.peek().equals("(")) {
              S.push(P.pop());
            }
            P.pop();
            E.pop();
            break; 
          default:
            S.push(E.pop()); 
        } 
      } 

      //Eliminacion de `impurezas´ en la expresiones algebraicas
      String infix = expr.replace(" ", "");
      String postfix = S.toString().replaceAll("[\\]\\[,]", "");

      //Mostrar resultados:
       System.out.println(postfix);
       Matriz miMatriz;
       miMatriz=new Matriz();
       miMatriz.expresionAlgebraica(postfix, dic,dicaux);
      

    }catch(Exception ex){ 
      System.out.println("Error en la expresión algebraica");
      System.err.println(ex);
    }
  } 

  //Depurar expresión algebraica
  private static String depurar(String s) {
    s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
    s = "(" + s + ")";
    String simbols = "+-*/()";
    String str = "";
  
    //Deja espacios entre operadores
    for (int i = 0; i < s.length(); i++) {
      if (simbols.contains("" + s.charAt(i))) {
        str += " " + s.charAt(i) + " ";
      }else str += s.charAt(i);
    }
    return str.replaceAll("\\s+", " ").trim();
  } 

  //Jerarquia de los operadores
  private static int pref(String op) {
    int prf = 99;
    if (op.equals("^")) prf = 5;
    if (op.equals("*") || op.equals("/")) prf = 4;
    if (op.equals("+") || op.equals("-")) prf = 3;
    if (op.equals(")")) prf = 2;
    if (op.equals("(")) prf = 1;
    return prf;
  }
  
  public void Guardararchivo(String comando,String[] datos,Map<String,ArrayList<String>> dic) throws IOException{
      if (datos.length==0){
          File archivo=new File("opermat2017.txt");
          BufferedWriter bw;
          if(archivo.exists()){
              bw=new BufferedWriter(new FileWriter(archivo));
          }
          else{
              bw=new BufferedWriter(new FileWriter(archivo));
          }
        bw.close();      
      }
  }
    }
