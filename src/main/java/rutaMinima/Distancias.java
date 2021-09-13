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

    private int optenerDistancia(Paises paises, String pais1, String c1, String pais2, String c2){
        boolean b=false;//bandera

        //indice de el pais y ciudad 1
        int idp1 = paises.countryItems.indexOf(pais1);
        int idc1 = paises.getStates(idp1).indexOf(c1);
        //indice de el pais y ciudad 2
        int idp2 = paises.countryItems.indexOf(pais1);
        int idc2 = paises.getStates(idp1).indexOf(c1);

        //creacion de la distancia
        int metros=(int)(Math.random()*(10000-200+1)+200);
        int [] distancia ={idp1,idc1,idp2,idc2,metros};//creacion de arreglo con los datos

        for (int[] x:listaDeDistancias) {//buscar si ya existe la distancia
            if((x[0]==idp1 && x[1]==idc1 && x[2]==idp2 && x[3]==idc2 )||(x[0]==idp2 && x[1]==idc2 && x[2]==idp1 && x[3]==idc1 ) ){
                return x[0];
            }
        }

        listaDeDistancias.add(distancia);
        return metros;

    }


}
