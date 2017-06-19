package opermat;
import java.util.ArrayList;
import java.util.Map;
import opermat.Interpretador;
import static opermat.OperMat.dic;

/**
 *
 * @author Bárbara Gutiérrez
 */
public class Receptor {
    public String comando;
    public String[] datos;
    
    /**
     *
     * @param comando
     * @param datos
     * @param dic
     */
    public void Recibir (String comando,String[] datos,Map<String,ArrayList<String>> dic){
        Interpretador miInterpretador;
        miInterpretador=new Interpretador();
        if (dic.containsKey(comando)){
            miInterpretador.Desplegar(comando, dic);
        }
        else{
        switch (comando) {
            case "acercade":
                miInterpretador.AcercaDe(comando,datos);
                break;
            case "ace":
                miInterpretador.AcercaDe(comando,datos);
                break;
            case "mae":
                miInterpretador.Mae(comando, datos);
                break;
            case "matrizaleatoriaenteros":
                miInterpretador.Mae(comando, datos);
                break;
            case "maf":
                miInterpretador.Maf(comando, datos);
                break;
            case "matrizaleatoriaflotantes":
                miInterpretador.Maf(comando, datos);
                break;
            case "lee":
                miInterpretador.Lee(comando, datos,dic);
                break;
            case"leer":
                miInterpretador.Lee(comando, datos,dic);
                break;
            case "sumaMatriz":
                miInterpretador.sumarMatriz(datos, dic);
                break;
            case "restaMatriz":
                miInterpretador.restarMatriz(datos, dic);
                break;
            case "multiplicaMatriz":
                miInterpretador.multiplicarMatriz(datos, dic);
                break;
            case "exponenciacionMatriz":
                miInterpretador.exponenciarMatriz(datos, dic);
                break;
            case "programador":
                miInterpretador.Programador(datos, dic);
                break;
        }
      }
        if (datos.length!=0){
            if ("=".equals(datos[0])){
                miInterpretador.Asignar(comando, datos, dic);
            }
        }
    }
}
