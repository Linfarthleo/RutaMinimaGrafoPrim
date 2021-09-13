package rutaMinima;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by glego on 12/11/2017.
 */
public class Paises {
    ArrayList<ObservableList<String>> statesItems = new ArrayList<>();

    ObservableList<String> countryItems =
            FXCollections.observableArrayList(
                    "Argentina",
                    "Bolivia",
                    "Brasil",
                    "Chile",
                    "Colombia",
                    /*"Costa Rica",
                    "Cuba",
                     */
                    "Ecuador"
                    /*"El Salvador",
                    "Guatemala",
                    "Honduras",
                    "México",
                    "Nicaragua",
                    "Panamá",
                    "Paraguay",
                    "Perú",
                    "Uruguay",
                    "Venezuela"*/
            );
    ObservableList<String> AeropuertosArgentinos =
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
    ObservableList<String> AeropuertosColombianos =
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
    ObservableList<String> AeropuertosBolivianos =
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
    ObservableList<String> AeropuertosBrasilenios =
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
    ObservableList<String> AeropuertosChilenos =
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
    ObservableList<String> AeropuertosEcuatorianos =
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


    public Paises() {
        statesItems.add(AeropuertosArgentinos);
        statesItems.add(AeropuertosBolivianos);
        statesItems.add(AeropuertosBrasilenios);
        statesItems.add(AeropuertosChilenos);
        statesItems.add(AeropuertosColombianos);
        statesItems.add(AeropuertosEcuatorianos);

    }

    public ObservableList<String> getCountries() {
        return countryItems;
    }

    public ObservableList<String> getStates(int index) {
        return statesItems.get(index);
    }

    public String getCountry(int index){
        return countryItems.get(index);
    }

    public int getSize(){
        return countryItems.size();
    }

}
