package rutaMinima;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Distancias {

    ArrayList<int[]> listaDeDistancias;
    //final int INF=99999;

    public Distancias() {
        listaDeDistancias = new ArrayList<>();

    }

    public int obtenerDistancia(Paises paises, String pais1, String c1, String pais2, String c2){
        boolean b=false;//bandera

        //indice de el pais y ciudad 1
        int idp1 = paises.countryItems.indexOf(pais1);
        int idc1 = paises.getStates(idp1).indexOf(c1);
        //indice de el pais y ciudad 2
        int idp2 = paises.countryItems.indexOf(pais2);
        int idc2 = paises.getStates(idp2).indexOf(c2);

        //si son iguales retorna 0 y se termina

        if(idp1==idp2 && idc1==idc2){
            return 0;
        }
        
        //creacion de la distancia
        int metros=(int)(Math.random()*(10000-200+1)+200);
        int [] distancia ={idp1,idc1,idp2,idc2,metros};//creacion de arreglo con los datos

        for (int[] x:listaDeDistancias) {//buscar si ya existe la distancia

            if((x[0]==idp1 && x[1]==idc1 && x[2]==idp2 && x[3]==idc2 )||(x[0]==idp2 && x[1]==idc2 && x[2]==idp1 && x[3]==idc1 ) ){
               return x[4];
            }
        }

        listaDeDistancias.add(distancia);

        return metros;

    }

    public ArrayList<int[]> getListaDeDistancias() {
        return listaDeDistancias;
    }


}
