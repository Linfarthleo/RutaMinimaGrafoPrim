package rutaMinima;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Paises {
    //En la clase paises se crean listas que almacenan los paises y sus ciudades, estos se relacionan entre si
    //con el indice de la lista.
    //Observable list permite que las listas puedan ser usadas dentro de la interfaz de view.fxml
    //un arraylist de Observablelist que almacena listas de las ciudades de cada pais que poseen aeropuertos
    ArrayList<ObservableList<String>> listasDeCiudades = new ArrayList<>();
    //lista de paises
    ObservableList<String> listaDePaises =
            FXCollections.observableArrayList(
                    "Argentina",
                    "Bolivia",
                    "Brasil",
                    "Chile",
                    "Colombia",
                    "Ecuador"

            );

    //constructor
    public Paises() {
        //primero se crean los paises con las ciudades que apareceran por defecto

        //lista de ciudades argentinas
        ObservableList<String> ciudadesArgentinas =
                FXCollections.observableArrayList(
                        "Buenos Aires",
                        "Catamarca",
                        "Chaco",
                        "Chubut",
                        "Córdoba",
                        "Corrientes",
                        "Entre Ríos",
                        "Formosa",
                        "Jujuy",
                        "La Pampa",
                        "La Rioja",
                        "Mendoza",
                        "Misiones",
                        "Neuquén",
                        "Río Negro",
                        "Salta",
                        "San Juan",
                        "San Luis",
                        "Santa Cruz",
                        "Santa Fe",
                        "Santiago del Estero",
                        "Tierra del Fuego",
                        "Tucumán"
                );
        //lista de ciudades argentinas
        ObservableList<String> ciudadesColombianas =
                FXCollections.observableArrayList(

                        "Bogotá",
                        "Medellin",
                        "Cali",
                        "Pereira",
                        "Barranquilla",
                        "Cartagena",
                        "Cucuta",
                        "Armenia",
                        "Yopal",
                        "Bucaramanga",
                        "Santa Marta",
                        "San Andrés",
                        "Monteria",
                        "Valledupar",
                        "Medellin Herrera",
                        "Pasto",
                        "Neiva"

                );
        //lista de ciudades argentinas
        ObservableList<String> ciudadesBolivianas =
                FXCollections.observableArrayList(
                        "Beni",
                        "Chuquisaca",
                        "Cochabamba",
                        "La Paz",
                        "Oruro",
                        "Pando",
                        "Potosí",
                        "Santa Cruz",
                        "Tarija"
                );
        //lista de ciudades argentinas
        ObservableList<String> ciudadesBrasilenias =
                FXCollections.observableArrayList(
                        "Acre",
                        "Alagoas",
                        "Amap\u00E1",
                        "Amazonas",
                        "Bahia",
                        "Cear\u00E1",
                        "Esp\u00EDrito Santo",
                        "Goi\u00E1s",
                        "Maranh\u00E3o",
                        "Mato Grosso",
                        "Mato Grosso do Sul",
                        "Minas Gerais",
                        "Par\u00E1",
                        "Para\u00EDba",
                        "Paran\u00E1",
                        "Pernambuco",
                        "Piau\u00ED",
                        "Rio de Janeiro",
                        "Rio Grande do Norte",
                        "Rio Grande do Sul",
                        "Rond\u00F4nia",
                        "Roraima",
                        "Santa Catarina",
                        "S\u00E3o Paulo",
                        "Sergipe",
                        "Tocantins"
                );
        //lista de ciudades argentinas
        ObservableList<String> ciudedesChilenas =
                FXCollections.observableArrayList(
                        "Antofagasta",
                        "Arica",
                        "Balmaceda",
                        "Calama",
                        "Caldera",
                        "Dalcahue",
                        "Freire",
                        "Iquique",
                        "Isla de Pascua",
                        "La Serena",
                        "Mariquina",
                        "Natales",
                        "Osorno",
                        "Puerto Montt",
                        "Punta Arenas",
                        "Santiago",
                        "Talcahuano"

                );
        //lista de ciudades argentinas
        ObservableList<String> ciudadesChilenas =
                FXCollections.observableArrayList(
                        "Andoas (Pastaza)",
                        "Catamayo",
                        "Cuenca",
                        "Cumbaratza(Zamora)",
                        "Esmeraldas",
                        "Guayaquill",
                        "Isla Baltra",
                        "Pastaza",
                        "Latacunga",
                        "Lorocachi (Pastaza)",
                        "Macas",
                        "Manta",
                        "NuevaLoja",
                        "Puerto Baquerizo Moreno",
                        "Puerto Francisco de Orellana",
                        "Salinas",
                        "Santa Rosa",
                        "Quito",
                        "Morona Santiago");

        //añade las listas de ciudades a la lista que las almecena
        listasDeCiudades.add(ciudadesArgentinas);
        listasDeCiudades.add(ciudadesBolivianas);
        listasDeCiudades.add(ciudadesBrasilenias);
        listasDeCiudades.add(ciudedesChilenas);
        listasDeCiudades.add(ciudadesColombianas);
        listasDeCiudades.add(ciudadesChilenas);

    }


    //metodo para ingresar un nuevo pais y ciudad o una ciudad a un pais exsitente
    public void ingresarPaisYCiudad(String pais, String ciudad) {
        if (!(listaDePaises.contains(pais))) {//si el pais no existe se crea uno nuevo añadiendolo a la lista de paises
            listaDePaises.add(pais);//se añade el pais que se paso como parametro
            //se añade una nueva lista de ciudades relacionada con el pais creado
            ObservableList<String> ciudadesPais = FXCollections.observableArrayList();
            listasDeCiudades.add(ciudadesPais);
        }
        //hasta este punto simpre va a existir un pais al que insertarle la ciudad
        //ya sea porque se creo o porque ya existia

        //se verifica que la ciudad no exista previamente para evitar duplicados
        if (!(listasDeCiudades.get(listaDePaises.indexOf(pais)).contains(ciudad))) {
            listasDeCiudades.get(listaDePaises.indexOf(pais)).add(ciudad);//se añade la ciudad a la lista de ciudades
        }
    }


    //getter del atributo listaDePaises
    public ObservableList<String> getListaDePaises() {
        return listaDePaises;
    }


    //Metodo que obtiene las ciudades de un pais pasandole el indice que las relaciona
    public ObservableList<String> getCiudades(int index) {
        return listasDeCiudades.get(index);
    }

    //metodo para obtener el pais dado el indice
    public String getCountry(int index) {
        return listaDePaises.get(index);
    }

    //metodo para obtener el tamaño de la lista de paises
    public int getSize() {
        return listaDePaises.size();
    }

}
