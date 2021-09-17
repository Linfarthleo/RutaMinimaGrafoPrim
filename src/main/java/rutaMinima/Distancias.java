package rutaMinima;

import java.util.ArrayList;

public class Distancias {
    /*
    La clase distancias es la encargada de generar distancias aleatoriamente, esta distancia es la misma de
    una ciudad1 a una ciudad2 que de la ciudad2 a la ciudad1, si la distancia que se pide es de una ciudad a si
    misma se retorna el valor de 0, esta clase sera usada para llenar la matriz de distacias en el algortimo de
    Prim
     */

    ArrayList<int[]> listaDeDistancias;//lista de las distancias ya creadas para mantener control

    public Distancias() {
        listaDeDistancias = new ArrayList<>();

    }

    /*
    El metodo obtenerDistancia retorna un entero de la distancia entre dos ciudades, toma por parametros
    un objeto Paises, y Strings con el nombre de dos ciudades con su pais respectivo
     */

    public int obtenerDistancia(Paises paises, String pais1, String c1, String pais2, String c2){

        //indice de el pais y ciudad 1
        int idp1 = paises.listaDePaises.indexOf(pais1);
        int idc1 = paises.getCiudades(idp1).indexOf(c1);
        //indice de el pais y ciudad 2
        int idp2 = paises.listaDePaises.indexOf(pais2);
        int idc2 = paises.getCiudades(idp2).indexOf(c2);

        //si son iguales retorna 0 y se termina

        if(idp1==idp2 && idc1==idc2){//si se trata de la misma ciudad retorna 0
            return 0;
        }
        //creacion de la distancia
        int metros=(int)(Math.random()*(10000-200+1)+200);//
        int [] distancia ={idp1,idc1,idp2,idc2,metros};//creacion de arreglo con los datos

        for (int[] x:listaDeDistancias) {//buscar si ya existe la distancia
            //busca si la distancia a sido generada antes
            if((x[0]==idp1 && x[1]==idc1 && x[2]==idp2 && x[3]==idc2 )||(x[0]==idp2 && x[1]==idc2 && x[2]==idp1 && x[3]==idc1 ) ){
               return x[4];//si ya fue generada antes retorna el valor previamente generado
            }
        }

        //Si no fue generado antes añade el arreglo a la lista es decir genera un nuevo registro de la distancia
        listaDeDistancias.add(distancia);

        //retorna la distancia generada
        return metros;

    }

    //metodo get
    public ArrayList<int[]> getListaDeDistancias() {
        return listaDeDistancias;
    }


}
