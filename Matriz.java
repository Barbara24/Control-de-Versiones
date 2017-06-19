package opermat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author Bárbara Gutiérrez
 */
public class Matriz {
    public String[] datos;
    public String nombre;
    
    /**
     *
     * @param nombre
     * @param datosf
     * @param datos
     * @param dic
     */
    public void CrearMatriz(String nombre,ArrayList<String>datosf,Map<String,ArrayList<String>> dic,String[]datos){
        int i;
        int j;
        int k;
        ArrayList<ArrayList<Integer>> resultadof;
        resultadof = new ArrayList<>();
        for (i=0;i<(datosf.size());i++){
            String entrada[];
            entrada=datosf.get(i).split(",");
            ArrayList<Integer> resultado;
            resultado=new ArrayList<>();
            for (j=0;j<entrada.length;j++){
                k=Integer.parseInt(entrada[j]);
                resultado.add(k);
            }
            resultadof.add(resultado);
        }
        if(revisarMatriz(resultadof)==true){
            Impresor miImpresor;
            miImpresor=new Impresor();
            miImpresor.ImprimirLee(nombre, datos);
            if(dic.containsKey(nombre)){
                dic.remove(nombre);
                dic.put(nombre, datosf);

            }
            else{
                dic.put(nombre, datosf);
            }
        }
        else{
            System.out.println((char)27 + "[31mLa matriz tiene que ser del mismo tamaño" + (char)27 + "[0m");
        }
    }
    
    public void Asignar(String nombre,ArrayList<String>datosf,Map<String,ArrayList<String>> dic,String[]datos){
        int i;
        int j;
        int k;
        ArrayList<ArrayList<Integer>> resultadof;
        resultadof = new ArrayList<>();
        for (i=0;i<(datosf.size());i++){
            String entrada[];
            entrada=datosf.get(i).split(",");
            ArrayList<Integer> resultado;
            resultado=new ArrayList<>();
            for (j=0;j<entrada.length;j++){
                k=Integer.parseInt(entrada[j]);
                resultado.add(k);
            }
            resultadof.add(resultado);
        }
        if(revisarMatriz(resultadof)==true){
            Impresor miImpresor;
            miImpresor=new Impresor();
            miImpresor.ImprimirAsig(nombre, datos);
            if(dic.containsKey(nombre)){
                dic.remove(nombre);
                dic.put(nombre, datosf);

            }
            else{
                dic.put(nombre, datosf);
            }
        }
        else{
            System.out.println((char)27 + "[31mLa matriz tiene que ser del mismo tamaño" + (char)27 + "[0m");
        }
    }
    
    public void Encontrarvalores(String nombre,Map<String,ArrayList<String>> dic){   
        Impresor miImpresor;
        miImpresor=new Impresor();
        if(dic.containsKey(nombre)){
            ArrayList<String> valores;
            valores = dic.get(nombre);
            miImpresor.ImprimirMatriz(nombre, valores); 
        }
        else{
            System.out.println((char)27 + "[31mLa matriz no existe" + (char)27 + "[0m");
        }
    }
    
    /**
     *
     * @param datos
     * @param dic
     */
    public void sumaMatriz (String[] datos,Map<String,ArrayList<String>> dic){
        Impresor miImpresor;
        miImpresor=new Impresor();
        if (dic.containsKey(datos[0])){
            ArrayList<String> valoresm1;
            valoresm1 = dic.get(datos[0]);
            if (dic.containsKey(datos[1])){
                ArrayList<String> valoresm2;
                valoresm2 = dic.get(datos[1]);
                if (revisar2Matriz(valoresm1,valoresm2)==true){
                int i;
                int n1;
                int n2;
                int k;
                int j;
                ArrayList<ArrayList<Integer>> resultadof;
                resultadof = new ArrayList<>();
                for (i=0;i<valoresm1.size();i++){
                    String entrada1[];
                    entrada1=valoresm1.get(i).split(",");
                    String entrada2[];
                    entrada2=valoresm2.get(i).split(",");
                    ArrayList<Integer> resultado;
                    resultado = new ArrayList<>();
                    for (j=0;j<entrada1.length;j++){
                        n1=Integer.parseInt(entrada1[j]);
                        n2=Integer.parseInt(entrada2[j]);
                        k=n1+n2;
                        resultado.add(k);
                    
                    }
                    resultadof.add(resultado);
                }
                miImpresor.ImprimirSuma(resultadof);
                }      
            else{
                System.out.println((char)27 + "[31mLas matrices tienen que ser del mismo tamaño" + (char)27 + "[0m");
            }
        }
            else{
                System.out.println((char)27 + "[31mLa matriz\t" +datos[1]+ "\tno existe" + (char)27 + "[0m");
            }
        }
        else{
            System.out.println((char)27 + "[31mLa matriz\t" +datos[0]+ "\tno existe" + (char)27 + "[0m");
        }
    } 
    
    
    /**
     *
     * @param m1
     * @param m2
     * @return
     */
    public boolean revisar2Matriz(ArrayList<String> m1,ArrayList<String> m2){
        if (m1.size()==m2.size()){
            if(m1.get(0).length()==m2.get(0).length()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public boolean revisar2Matrizaux(ArrayList<String> m1,ArrayList<ArrayList<Integer>> m2){
        if (m1.size()==m2.size()){
            if(m1.get(0).length()==m2.get(0).size()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    /**
     *
     * @param m1
     * @return
     */
    public boolean revisarMatriz(ArrayList<ArrayList<Integer>> m1){
        int i;
        int k;
        int j = 0;
        k=m1.get(0).size();
        for(i=1;i<m1.size();i++){
            if (m1.get(i).size()==k){
                j++;
            }
            else{
            }
        }
        if(j==(m1.size()-1)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     *
     * @param datos
     * @param dic
     */
    public void restaMatriz(String[] datos,Map<String,ArrayList<String>> dic){
        Impresor miImpresor;
        miImpresor=new Impresor();
        if (dic.containsKey(datos[0])){
            ArrayList<String> valoresm1;
            valoresm1 = dic.get(datos[0]);
            if (dic.containsKey(datos[1])){
                ArrayList<String> valoresm2;
                valoresm2 = dic.get(datos[1]);
                if (revisar2Matriz(valoresm1,valoresm2)==true){
                int i;
                int n1;
                int n2;
                int k;
                int j;
                ArrayList<ArrayList<Integer>> resultadof;
                resultadof = new ArrayList<>();
                for (i=0;i<valoresm1.size();i++){
                    String entrada1[];
                    entrada1=valoresm1.get(i).split(",");
                    String entrada2[];
                    entrada2=valoresm2.get(i).split(",");
                    ArrayList<Integer> resultado;
                    resultado = new ArrayList<>();
                    for (j=0;j<entrada1.length;j++){
                        n1=Integer.parseInt(entrada1[j]);
                        n2=Integer.parseInt(entrada2[j]);
                        k=n1-n2;
                        resultado.add(k);
                    
                    }
                    resultadof.add(resultado);
                }
                miImpresor.ImprimirSuma(resultadof);
                }      
            else{
                System.out.println((char)27 + "[31mLas matrices tienen que ser del mismo tamaño" + (char)27 + "[0m");
            }
        }
            else{
                System.out.println((char)27 + "[31mLa matriz\t" +datos[1]+ "\tno existe" + (char)27 + "[0m");
            }
        }
        else{
            System.out.println((char)27 + "[31mLa matriz\t" +datos[0]+ "\tno existe" + (char)27 + "[0m");
        }
    }
    
    public void multiplicaMatriz(String[] datos,Map<String,ArrayList<String>> dic){
        Impresor miImpresor;
        miImpresor=new Impresor();
        if (dic.containsKey(datos[0])){
        ArrayList<String> valoresm1;
        valoresm1 = dic.get(datos[0]);
            if (dic.containsKey(datos[1])){
                ArrayList<String> valoresm2;
                valoresm2 = dic.get(datos[1]);
                if (valoresm1.size()==valoresm2.get(0).length()){
                    int i;
                    int j;
                    int k;
                    int n1;
                    int n2;
                    int finaln=0;
                    ArrayList<ArrayList<Integer>> resultadof;
                    resultadof = new ArrayList<>();
                    for (i=0;i<valoresm1.size();i++){
                        String entrada1[];
                        entrada1=valoresm1.get(i).split(",");
                        ArrayList<Integer> resultado;
                        resultado = new ArrayList<>();
                        for (j=0;j<valoresm2.get(0).length()-1;j++){
                            finaln=0;
                            for(k=0;k<valoresm2.size();k++){
                                String entrada2[];
                                entrada2=valoresm2.get(k).split(",");
                                n1=Integer.parseInt(entrada1[k]);
                                n2=Integer.parseInt(entrada2[j]);

                                finaln+=n1*n2;
                            }
                            resultado.add(finaln);
                        }
                        resultadof.add(resultado);
                    }
                    miImpresor.ImprimirSuma(resultadof);
                    }
            else{
                System.out.println((char)27 + "[31mLas matrices tienen que ser del mismo tamaño" + (char)27 + "[0m");
            }
        }
            else{
                System.out.println((char)27 + "[31mLa matriz\t" +datos[1]+ "\tno existe" + (char)27 + "[0m");
            }
        }
        else{
            System.out.println((char)27 + "[31mLa matriz\t" +datos[0]+ "\tno existe" + (char)27 + "[0m");
        }
    }
    
    public void exponenciacionMatriz(String[] datos,Map<String,ArrayList<String>> dic){
        Impresor miImpresor;
        miImpresor=new Impresor();
        if (dic.containsKey(datos[0])){
            ArrayList<String> valoresm1;
            valoresm1 = dic.get(datos[0]);
            int i;
            int k;
            int n1;
            int numf;
            ArrayList<ArrayList<Integer>> resultadof;
            resultadof = new ArrayList<>();
            for(i=0;i<valoresm1.size();i++){
                String entrada1[];
                entrada1=valoresm1.get(i).split(",");
                ArrayList<Integer> resultado;
                resultado = new ArrayList<>();
                for (k=0;k<entrada1.length;k++){
                    n1=Integer.parseInt(entrada1[k]);
                    numf=(int) Math.pow(n1,Integer.parseInt(datos[1]) );   
                    resultado.add(numf);
                }
            resultadof.add(resultado);
            }
            miImpresor.ImprimirSuma(resultadof);   
        }
        else{
           System.out.println((char)27 + "[31mLa matriz\t" +datos[0]+ "\tno existe" + (char)27 + "[0m"); 
        }
    }
    
    public void ascendenteMatriz(String[] datos,Map<String,ArrayList<String>> dic){
        Impresor miImpresor;
        miImpresor=new Impresor();
            ArrayList<String> valoresm1;
            valoresm1 = dic.get(datos[0]);
            int i;
            int j;
            int k;
            ArrayList<Integer> resultado;
            resultado = new ArrayList<>();
            for (i=0;i<valoresm1.size();i++){
                String entrada1[];
                entrada1=valoresm1.get(i).split(",");
                for(j=0;j<entrada1.length;j++){
                    k=Integer.parseInt(entrada1[j]);
                    resultado.add(k);
                }   
            }
            int cont1;
            int cont3;
            int a;
            ArrayList<Integer> resultadoordenado;
            resultadoordenado = new ArrayList<>();
            for(cont1=0;cont1<resultado.size();cont1++){
                if(cont1==0){
                    resultadoordenado.add(resultado.get(0));
                }
                else{
                    a=0;
                    for(cont3=0;cont3<resultadoordenado.size();cont3++){
                        if (resultado.get(cont1)>resultadoordenado.get(cont3)){
                           a++;
                        }
                        else{
                           resultadoordenado.add(cont3, resultado.get(cont1));
                           break;
                        }
                    }
                    if (a==resultadoordenado.size()){
                        resultadoordenado.add(resultado.get(cont1));
                    }
                }  
            }
            int cont2;
            cont2=0;
            int b;
            ArrayList<ArrayList<Integer>> resultadof;
            resultadof = new ArrayList<>();
            String entrada3[];
            entrada3=valoresm1.get(0).split(",");
            int columna;
            columna=entrada3.length;         
            while (cont2<resultadoordenado.size()){
                ArrayList<Integer> filas;
                filas = new ArrayList<>();
                for (b=0;b<columna;b++){
                    filas.add(resultadoordenado.get(cont2)); 
                    cont2+=1;
                }
                resultadof.add(filas);   
            }
            miImpresor.ImprimirSuma(resultadof);
    }
    
    public void descendenteMatriz(String[] datos,Map<String,ArrayList<String>> dic){
        Impresor miImpresor;
        miImpresor=new Impresor();
            ArrayList<String> valoresm1;
            valoresm1 = dic.get(datos[0]);
            int i;
            int j;
            int k;
            ArrayList<Integer> resultado;
            resultado = new ArrayList<>();
            for (i=0;i<valoresm1.size();i++){
                String entrada1[];
                entrada1=valoresm1.get(i).split(",");
                for(j=0;j<entrada1.length;j++){
                    k=Integer.parseInt(entrada1[j]);
                    resultado.add(k);
                }   
            }
            int cont1;
            int cont3;
            int a;
            ArrayList<Integer> resultadoordenado;
            resultadoordenado = new ArrayList<>();
            for(cont1=0;cont1<resultado.size();cont1++){
                if(cont1==0){
                    resultadoordenado.add(resultado.get(0));
                }
                else{
                    a=0;
                    for(cont3=0;cont3<resultadoordenado.size();cont3++){
                        if (resultado.get(cont1)<resultadoordenado.get(cont3)){
                           a++;
                        }
                        else{
                           resultadoordenado.add(cont3, resultado.get(cont1));
                           break;
                        }
                    }
                    if (a==resultadoordenado.size()){
                        resultadoordenado.add(resultado.get(cont1));
                    }
                }  
            }
            int cont2;
            cont2=0;
            int b;
            ArrayList<ArrayList<Integer>> resultadof;
            resultadof = new ArrayList<>();
            String entrada3[];
            entrada3=valoresm1.get(0).split(",");
            int columna;
            columna=entrada3.length;         
            while (cont2<resultadoordenado.size()){
                ArrayList<Integer> filas;
                filas = new ArrayList<>();
                for (b=0;b<columna;b++){
                    filas.add(resultadoordenado.get(cont2)); 
                    cont2+=1;
                }
                resultadof.add(filas);   
            }
            miImpresor.ImprimirSuma(resultadof);  
    }
