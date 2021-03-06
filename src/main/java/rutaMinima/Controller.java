package rutaMinima;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private Paises listaPaises;//Objeto de la calse paises
    private ArrayList<String> seleccionados;//Almacena las ciudades Selecionadas
    private ArrayList<String> selecionadosP;//Alamcena los paises seleccionados(se relaciona con la ciudades mediante el indice)
    private Distancias distanciasGeneradas;

    //Inicialización e implementación de todos los objetos de cada interfaz

    @FXML
    private ComboBox<String> cbPais;
    @FXML
    private ComboBox<String> cbCiudad;
    @FXML
    private Button btnInsertar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnVaciar;
    @FXML
    private TextArea taCiudades;
    @FXML
    private TextArea cuadroRutas;

    @FXML
    private AnchorPane seleccionarCiudadesPanel;
    @FXML
    private AnchorPane ingresarCiudadesPanel;
    @FXML
    private AnchorPane rutasOptimasPanel;
    @FXML
    private AnchorPane mainPanel;
    @FXML
    private ImageView arrowUno;
    @FXML
    private ImageView arrowDos;
    @FXML
    private ImageView arrowTres;
    @FXML
    private TextField ingresarPaisTextField;
    @FXML
    private TextField ingresarCiudadTextField;
    @FXML
    private TextArea rutasIngresadasTextArea;


    //Para regresar a la ventana de inicio
    //atributos para arrastrar ventana
    private double xOffset;
    private double yOffset;

    public void onInicioImageClicked(MouseEvent event) {
        //Para regresar a la anterior ventana de inicio
        try {
            //Se crea una nueva ventana cuando se de lugar al evento, en este caso al hacer click, con sus respectivos atributos
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            Window window = oldScene.getWindow();
            Stage stage = (Stage) window;
            stage.hide();//oculta la ventana actual
            //Se crea la ventana e inicializa con sus atributos
            Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
            //Características importantes de la intefaz padre, la cual contiene a las demas interfaces
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.setTitle("Calculadora de Rutas Mínimas Entre Ciudades");
            newStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icons8_world_map.png")));
            scene.setFill(Color.TRANSPARENT);
            newStage.setScene(scene);
            newStage.show();
            //inicializar evento en el moused pressed que permite mover cuando este presionado el mouse en cualquier parte del menu
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            //evento que permite arrastrar por la pantalla al anchor pane menu
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    newStage.setX(event.getScreenX() - xOffset);
                    newStage.setY(event.getScreenY() - yOffset);
                }
            });
            //Si se produce un error que se lo imprima en la consola
        } catch (IOException ex) {
            System.out.println("Se ha producido el error: " + ex);
        }
    }


    //boton para salir, el cual genera un mensaje de alerta para confirmar que realmente se desea salir del programa
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


    //Método para navegación entre pestañas, para le módulo de seleccionar Ciudades
    public void onSeleccionarCiudadesButtonClicked(MouseEvent event) {
        //Condicional que ocultara el modulo si ya esta abierto
        if (mainPanel.isVisible() && seleccionarCiudadesPanel.isVisible()) {
            mainPanel.setVisible(false);
            arrowUno.setVisible(false);
            return;
        }
        //Hace visible al pane de seleccionar ciudades
        mainPanel.setVisible(true);
        seleccionarCiudadesPanel.setVisible(true);
        arrowUno.setVisible(true);
        ingresarCiudadesPanel.setVisible(false);
        arrowDos.setVisible(false);
        rutasOptimasPanel.setVisible(false);
        arrowTres.setVisible(false);
    }

    //Método para navegación entre pestañas, para le módulo de ingresar Ciudades
    public void onIngresarCiudadesButtonClicked(MouseEvent event) {
        //Condicional que ocultara el modulo si ya esta abierto
        if (mainPanel.isVisible() && ingresarCiudadesPanel.isVisible()) {
            mainPanel.setVisible(false);
            arrowDos.setVisible(false);
            return;
        }
        mainPanel.setVisible(true);
        seleccionarCiudadesPanel.setVisible(false);
        arrowUno.setVisible(false);
        //Hace visible al pane de Ingresar Ciudades
        ingresarCiudadesPanel.setVisible(true);
        arrowDos.setVisible(true);
        rutasOptimasPanel.setVisible(false);
        arrowTres.setVisible(false);
    }
    //Método para navegación entre pestañas, para le módulo de mostrar rutas optimas

    public void onRutasOptimasButtonClicked(MouseEvent event) {
        //Condicional que ocultara el modulo si ya esta abierto
        if (mainPanel.isVisible() && rutasOptimasPanel.isVisible()) {
            mainPanel.setVisible(false);
            arrowTres.setVisible(false);
            return;
        }
        mainPanel.setVisible(true);
        seleccionarCiudadesPanel.setVisible(false);
        arrowUno.setVisible(false);
        ingresarCiudadesPanel.setVisible(false);
        arrowDos.setVisible(false);
        //Hace visible al pane de RutasOptimas
        rutasOptimasPanel.setVisible(true);
        arrowTres.setVisible(true);
    }


//Parte de Selecionar Ciudades

    //metodo que se ejecuta cuando se preciona el combobox
    public void onActionCBPais(ActionEvent event) {
        cbCiudad.setDisable(false);//habilita el combo box de ciudad
        cbCiudad.setDisable(false);
        for (int i = 0; i < listaPaises.getSize(); i++) {//busca las ciudades del pais correspondiente
            if (cbPais.getValue().equals(listaPaises.getCountry(i))) {
                cbCiudad.setItems(listaPaises.getCiudades(i));//llena el combo box de paises
            }
        }
    }

    //cuando se usa el combo box de ciudad
    public void onActionCBCiudad(ActionEvent event) {
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
    public void onBtnInsertarClicked(MouseEvent event) {
        btnEliminar.setDisable(false);//una ves que se inserta una ciudad se habilita el boton eliminar
        String str = cbCiudad.getValue();//obtiene la ciudad seleccionada
        //System.out.println(str);
        if (str == null) {//si no se ha selecionado una ciudad imprime un mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Selecione una Ciudad");
            alert.showAndWait();
        } else {
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
    public boolean comprobarExistencia(String str) {

        for (String x : seleccionados) {
            if (x.equals(str)) {
                //recorre la lista de ciudades selecionadas
                //retorna false si se encuentra
                return false;
            }
        }
        return true;//retorna verdadero si no
    }

    //boton para eliminar una d la ciuades
    public void onBtnEliminarClicked(MouseEvent event) {
        String str = cbCiudad.getValue();//obtinene el string de la ciudad a eliminar
        if (!comprobarExistencia(str)) {//comprueba que exista
            selecionadosP.remove(seleccionados.indexOf(str));//remueve la posicion del pais selecionado
            seleccionados.remove(str);//remueve la ciudad selecionado
            String ac = "";
            for (String x : seleccionados) {
                ac += x + "\n";

            }
            //actualiza el text area
            taCiudades.setText(ac);

        } else {//si no esta la ciudad dentro de la lista imprime el error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La ciudad no existe dentro de la Lista");
            alert.showAndWait();
        }
    }

    //Parte de insertar ciudades
    public void onIngresarPaisYCiudadClicked(ActionEvent event) {
        //Condicional para verificar que no se ingresen datos vacios, si no emitirá una alerta para que se ingrese datos
        if (ingresarPaisTextField.getText() == "" || ingresarCiudadTextField.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Ingrese Datos");
            alert.showAndWait();
        } else {
            //Si no se agrega lo que se haya escrito en Pais y ciudad en un arreglo con la ayuda del metodo ingresarPaisYCiudad
            listaPaises.ingresarPaisYCiudad(ingresarPaisTextField.getText(), ingresarCiudadTextField.getText());
            //Imprime en un TextArea el pais y ciudad que se agrego al arreglo y por ende al combobox de seleccion
            rutasIngresadasTextArea.appendText("País: " + ingresarPaisTextField.getText() + " --> Ciudad: " + ingresarCiudadTextField.getText() + "\n");
        }
        //Se debe actualizar los combo box de módulo seleccionar paises para que la eleccion se haga con normalidad y los datos recien ingresados
        cbPais.setItems(listaPaises.getListaDePaises());
        //Y a su vez se debe reiniciar los cuadros de texto para que se vacien , como esta a continuacion
        ingresarPaisTextField.setText("");
        ingresarCiudadTextField.setText("");
    }

    //Parte de conectar ciudades

    //boton conectar ciudades
    public void onConectarCiudadesButtonClicked(ActionEvent event) {
        //si se ha seleccinado las ciudades inmediatamente despues de presionar el boton, tambien cambiara de interfaz
        //al modulo de rutas optimas(lo hace visible y los demas se los oculta), que es ahí donde se mostraran los resultados
        if (!seleccionados.isEmpty()) {
            mainPanel.setVisible(true);
            seleccionarCiudadesPanel.setVisible(false);
            arrowUno.setVisible(false);
            ingresarCiudadesPanel.setVisible(false);
            arrowDos.setVisible(false);
            rutasOptimasPanel.setVisible(true);
            arrowTres.setVisible(true);

            matrizCostos();
        } else {//si no se ha selecionado una ciudad despliega un mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No ha selecionado ninguna ciudad");
            alert.showAndWait();

        }
    }

    //metodo para llenar la matriz de costos
    public void matrizCostos() {

        AlgPrim p = new AlgPrim(seleccionados.size());//Objeto AlgPrim
        //Distancias distanciasGeneradas =new Distancias();//Objeto distancias
        int nodes, i, j;

        //asigna el nuemro de nodos que es el numero de ciudades selecionadas
        nodes = seleccionados.size();

        //Ingresar los Pesos o Costos a la Matriz de Adyacencia etiquetada
        for (i = 1; i <= nodes; i++)
            for (j = 1; j <= nodes; j++) {
                //genera o  obtiene la distancia
                p.costo[i][j] = distanciasGeneradas.obtenerDistancia(listaPaises, selecionadosP.get(i - 1),
                        seleccionados.get(i - 1), selecionadosP.get(j - 1), seleccionados.get(j - 1));
                System.out.println(p.costo[i][j]);

                if (p.costo[i][j] == 0)//si la distancia es 0 asigna infinito
                    p.costo[i][j] = 999999;
            }

        p.esVisitado[1] = 1;
        //coloca el el text area la forma en la que se deben conectar las
        //ciudades para conseguir el arbol de expansion minima
        cuadroRutas.setText(p.calc(nodes, selecionadosP, seleccionados));

    }

    //inicializar arreglos y listas
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaPaises = new Paises();
        cbPais.setItems(listaPaises.getListaDePaises());
        seleccionados = new ArrayList<>();
        selecionadosP = new ArrayList<>();
        distanciasGeneradas = new Distancias();

    }

}