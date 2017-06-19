package opermat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bárbara Gutiérrez
 */
public class Impresor {
    
    public void ImprimirAcercaDe(String mensaje){
        System.out.println(mensaje);
        
    }
    public void ImprimirMae(ArrayList<ArrayList<Integer>> resultado){
        int i;
        for (i=0;i<resultado.size();i++){
            System.out.println(resultado.get(i));
        }
        
    }
    
    public void ImprimirMaf(ArrayList<ArrayList<Double>> resultado){
        int i;
        for (i=0;i<resultado.size();i++){
            System.out.println(resultado.get(i));
        }
    }
    public void ImprimirLee(String comando,String[] datos){
        System.out.println(datos[0]);
        int i;
        int j;
        int k;
        for (i=1;i<(datos.length-1);i++){
            String entrada[];
            entrada=datos[i].split(",");
            ArrayList<Integer> resultado;
            resultado = new ArrayList<>();
            for (j=0;j<entrada.length;j++){
               k=Integer.parseInt(entrada[j]);
               resultado.add(k);   
            }
            System.out.println(resultado);
        }        
    }
    
    public void ImprimirAsig(String comando,String[] datos){
        System.out.println(comando);
        int i;
        int j;
        int k;
        for (i=1;i<(datos.length-1);i++){
            String entrada[];
            entrada=datos[i].split(",");
            ArrayList<Integer> resultado;
            resultado = new ArrayList<>();
            for (j=0;j<entrada.length;j++){
               k=Integer.parseInt(entrada[j]);
               resultado.add(k);   
            }
            System.out.println(resultado);
        } 
    }

    /**
     *
     * @param comando
     * @param valores
     */
    public void ImprimirMatriz(String comando,ArrayList<String> valores){
        int i;
        int j;
        int k;
        for (i=0;i<(valores.size());i++){
            String entrada[];
            entrada=valores.get(i).split(",");
            ArrayList<Integer> resultado;
            resultado=new ArrayList<>();
            for (j=0;j<entrada.length;j++){
                k=Integer.parseInt(entrada[j]);
                resultado.add(k);
            }
            System.out.println(resultado);
        }   
    }
    
    public void ImprimirSuma(ArrayList<ArrayList<Integer>> resultado){
        int i;
        for(i=0;i<resultado.size();i++){
            System.out.println(resultado.get(i));
        }
    }
}
