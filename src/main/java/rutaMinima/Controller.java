package rutaMinima;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private Paises listaPaises;//Objeto de la calse paises
    private ArrayList<String> seleccionados;//Almacena las ciudades Selecionadas
    private ArrayList<String> selecionadosP;//Alamcena los paises seleccionados(se relaciona con la ciudades mediante el indice)
    private Distancias distanciasGeneradas;

    @FXML private ComboBox<String> cbPais;
    @FXML private ComboBox<String> cbCiudad;
    @FXML private Button btnInsertar;
    @FXML private Button btnEliminar;
    @FXML private Button btnVaciar;
    @FXML private TextArea taCiudades;
    @FXML private TextArea cuadroRutas;

    @FXML private AnchorPane seleccionarCiudadesPanel;
    @FXML private AnchorPane ingresarCiudadesPanel;
    @FXML private AnchorPane rutasOptimasPanel;
    @FXML private AnchorPane mainPanel;
    @FXML private ImageView arrowUno;
    @FXML private ImageView arrowDos;
    @FXML private ImageView arrowTres;
    @FXML private TextField ingresarPaisTextField;
    @FXML private TextField ingresarCiudadTextField;
    @FXML private TextArea rutasIngresadasTextArea;

    //boton para salir
    public void onExitButtonClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setContentText("¿Está seguro que desea salir?");
        alert.showAndWait();
        if (alert.getResult().equals(ButtonType.OK)) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void onSeleccionarCiudadesButtonClicked(MouseEvent event) {
        if (mainPanel.isVisible()&&seleccionarCiudadesPanel.isVisible()) {
            mainPanel.setVisible(false);
            arrowUno.setVisible(false);
            return;
        }
        mainPanel.setVisible(true);
        seleccionarCiudadesPanel.setVisible(true);
        arrowUno.setVisible(true);
        ingresarCiudadesPanel.setVisible(false);
        arrowDos.setVisible(false);
        rutasOptimasPanel.setVisible(false);
        arrowTres.setVisible(false);
    }

    public void onIngresarCiudadesButtonClicked(MouseEvent event) {
        if (mainPanel.isVisible()&&ingresarCiudadesPanel.isVisible()) {
            mainPanel.setVisible(false);
            arrowDos.setVisible(false);
            return;
        }
        mainPanel.setVisible(true);
        seleccionarCiudadesPanel.setVisible(false);
        arrowUno.setVisible(false);
        ingresarCiudadesPanel.setVisible(true);
        arrowDos.setVisible(true);
        rutasOptimasPanel.setVisible(false);
        arrowTres.setVisible(false);
    }
    public void onRutasOptimasButtonClicked(MouseEvent event) {
        if (mainPanel.isVisible()&&rutasOptimasPanel.isVisible()) {
            mainPanel.setVisible(false);
            arrowTres.setVisible(false);
            return;
        }
        mainPanel.setVisible(true);
        seleccionarCiudadesPanel.setVisible(false);
        arrowUno.setVisible(false);
        ingresarCiudadesPanel.setVisible(false);
        arrowDos.setVisible(false);
        rutasOptimasPanel.setVisible(true);
        arrowTres.setVisible(true);
    }


//Parte de Selecionar Ciudades

    //metodo que se ejecuta cuando se preciona el combobox
    public void onActionCBPais(ActionEvent event){
        cbCiudad.setDisable(false);//habilita el combo box de ciudad
        cbCiudad.setDisable(false);
        for (int i=0;i< listaPaises.getSize();i++){//busca las ciudades del pais correspondiente
            if(cbPais.getValue().equals(listaPaises.getCountry(i))){
                cbCiudad.setItems(listaPaises.getCiudades(i));//llena el combo box de paises
            }
        }
    }

    //cuando se usa el combo box de ciudad
    public void onActionCBCiudad(ActionEvent event){
        //se habilita el boton de selecionar una vez selecionada una ciudad
        btnInsertar.setDisable(false);
    }
/*
    public void onBtnVaciarClicked(MouseEvent event){

        System.out.println("Hola");
        selecionadosP.removeAll(selecionadosP);
        seleccionados.removeAll(seleccionados);
        taCiudades.setText("");

    }*/

    //boton selecionar
    public void onBtnInsertarClicked(MouseEvent event){
        btnEliminar.setDisable(false);//una ves que se inserta una ciudad se habilita el boton eliminar
        String str = cbCiudad.getValue();//obtiene la ciudad seleccionada
        //System.out.println(str);
        if(str==null){//si no se ha selecionado una ciudad imprime un mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Selecione una Ciudad");
            alert.showAndWait();
        }else {
            if (comprobarExistencia(str)) {//comprueba si hay valores repetidos
                selecionadosP.add(cbPais.getValue());//añade los paises seleccionados a una lista
                seleccionados.add(str);//añade las ciudades selecionadas a una lista
                String ac = "";//acumulador
                for (String x : seleccionados) {
                    ac += x + "\n";//recorre la lista de ciudades y añade los nombre al string ac
                }
                taCiudades.setText(ac);//Escribe el string ac en el Text Area
            } else {

                //si es que la ciudad ya fue ingresada antes imprime un mensaje de error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Ciudad Duplicada");
                alert.showAndWait();
            }
            //desabilita el boton insertar hasta que se escoja otra ciudad
            btnInsertar.setDisable(true);
        }
    }

    //metodo para comprobar la existencia dentro de la lista
    public boolean comprobarExistencia(String str){

        for (String x: seleccionados){
                if(x.equals(str)){
                    //recorre la lista de ciudades selecionadas
                    //retorna false si se encuentra
                return false;
            }
        }
        return true;//retorna verdadero si no
    }

    //boton para eliminar una d la ciuades
    public void onBtnEliminarClicked(MouseEvent event){
        String str = cbCiudad.getValue();//obtinene el string de la ciudad a eliminar
        if(!comprobarExistencia(str)){//comprueba que exista
            selecionadosP.remove(seleccionados.indexOf(str));//remueve la posicion del pais selecionado
            seleccionados.remove(str);//remueve la ciudad selecionado
            String ac = "";
            for (String x : seleccionados) {
                ac += x + "\n";

            }
            //actualiza el text area
            taCiudades.setText(ac);

        }else{//si no esta la ciudad dentro de la lista imprime el error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La ciudad no existe dentro de la Lista");
            alert.showAndWait();
        }
    }

    //Parte de insertar ciudades
    public void onIngresarPaisYCiudadClicked(ActionEvent event){
        if(ingresarPaisTextField.getText()==""||ingresarCiudadTextField.getText()==""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Ingrese Datos");
            alert.showAndWait();
        }else {
            listaPaises.ingresarPaisYCiudad(ingresarPaisTextField.getText(), ingresarCiudadTextField.getText());
            rutasIngresadasTextArea.appendText("País: " +ingresarPaisTextField.getText()+" --> Ciudad: "+ ingresarCiudadTextField.getText()+"\n");
        }
        cbPais.setItems(listaPaises.getListaDePaises());
        ingresarPaisTextField.setText("");
        ingresarCiudadTextField.setText("");
    }

    //Parte de conectar ciudades

    //boton conectar ciudades
    public void onConectarCiudadesButtonClicked(ActionEvent event){

        if(!seleccionados.isEmpty()){
            mainPanel.setVisible(true);
            seleccionarCiudadesPanel.setVisible(false);
            arrowUno.setVisible(false);
            ingresarCiudadesPanel.setVisible(false);
            arrowDos.setVisible(false);
            rutasOptimasPanel.setVisible(true);
            arrowTres.setVisible(true);

            matrizCostos();
        }else{//si no se ha selecionado una ciudad despliega un mensaje de error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No ha selecionado ninguna ciudad");
                alert.showAndWait();

        }
    }

    //metodo para llenar la matriz de costos
    public void matrizCostos(){

        AlgPrim p = new AlgPrim (seleccionados.size());//Objeto AlgPrim
        //Distancias distanciasGeneradas =new Distancias();//Objeto distancias
        int nodes,i,j;

        //asigna el nuemro de nodos que es el numero de ciudades selecionadas
        nodes= seleccionados.size();

        //Ingresar los Pesos o Costos a la Matriz de Adyacencia etiquetada
        for(i=1;i<=nodes;i++)
            for(j=1;j<=nodes;j++)
            {
                //genera o  obtiene la distancia
                p.costo[i][j]=distanciasGeneradas.obtenerDistancia(listaPaises, selecionadosP.get(i-1),
                        seleccionados.get(i-1),selecionadosP.get(j-1), seleccionados.get(j-1));
                System.out.println(p.costo[i][j]);

                if(p.costo[i][j]==0)//si la distancia es 0 asigna infinito
                    p.costo[i][j]=999999;
            }

        p.esVisitado[1]=1;
            //coloca el el text area la forma en la que se deben conectar las
        //ciudades para conseguir el arbol de expansion minima
        cuadroRutas.setText(p.calc(nodes,selecionadosP, seleccionados));

    }

    //inicializar
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            listaPaises=new Paises();
            cbPais.setItems(listaPaises.getListaDePaises());
            seleccionados =new ArrayList<>();
            selecionadosP=new ArrayList<>();
            distanciasGeneradas =new Distancias();

    }

}