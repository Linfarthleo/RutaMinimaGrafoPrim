package rutaMinima;

import javafx.application.Platform;
import javafx.collections.ObservableList;
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
    private Paises listaPaises;
    private ArrayList<String> selecionados;
    private ArrayList<String> selecionadosP;

    @FXML private ComboBox<String> cbPais;
    @FXML private ComboBox<String> cbCiudad;
    @FXML private Button btnInsertar;
    @FXML private Button btnEliminar;
    @FXML private TextArea taCiudades;
    @FXML private AnchorPane seleccionarCiudadesPanel;
    @FXML private AnchorPane ingresarCiudadesPanel;
    @FXML private AnchorPane rutasOptimasPanel;
    @FXML private AnchorPane mainPanel;
    @FXML private ImageView arrowUno;
    @FXML private ImageView arrowDos;
    @FXML private ImageView arrowTres;
    @FXML private TextField ingresarPaisTextField;
    @FXML private TextField ingresarCiudadTextField;
    @FXML private Button btn_insertar;





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




//Parte Emilio

    public void onActionCBPais(ActionEvent event){
        cbCiudad.setDisable(false);
        cbCiudad.setDisable(false);
        for (int i=0;i< listaPaises.getSize();i++){
            if(cbPais.getValue().equals(listaPaises.getCountry(i))){
                cbCiudad.setItems(listaPaises.getStates(i));
            }
        }
    }

    public void onActionCBCiudad(ActionEvent event){
        btnInsertar.setDisable(false);

    }

    public void onBtnInsertarClicked(MouseEvent event){
        btnEliminar.setDisable(false);
        String str = cbCiudad.getValue();
        System.out.println(str);
        if(str==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Selecione una Ciudad");
            alert.showAndWait();
        }else {
            if (comprobarExistencia(str)) {//comprueba si hay valores repetidos
                selecionadosP.add(cbPais.getValue());
                selecionados.add(str);
                String ac = "";
                for (String x : selecionados) {
                    ac += x + "\n";

                }
                taCiudades.setText(ac);
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Ciudad Duplicada");
                alert.showAndWait();

            }
            btnInsertar.setDisable(true);
        }
    }

    public boolean comprobarExistencia(String str){

        for (String x:selecionados){
                if(x.equals(str)){
                return false;
            }
        }
        return true;
    }

    public void onBtnEliminarClicked(MouseEvent event){
        String str = cbCiudad.getValue();
        if(!comprobarExistencia(str)){//comprueba que exista
            selecionados.remove(str);
            String ac = "";
            for (String x : selecionados) {
                ac += x + "\n";

            }
            taCiudades.setText(ac);

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La ciudad no existe dentro de la Lista");
            alert.showAndWait();
        }
    }

    //Parte Leo

    public void onIngresarPaisYCiudadClicked(ActionEvent event){
        if(ingresarPaisTextField.getText()==null||ingresarCiudadTextField.getText()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Ingrese Datos");
            alert.showAndWait();
        }else {
            listaPaises.ingresarPaisYCiudad(ingresarPaisTextField.getText(), ingresarCiudadTextField.getText());
        }
        cbPais.setItems(listaPaises.getCountries());
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            listaPaises=new Paises();
            cbPais.setItems(listaPaises.getCountries());
            selecionados=new ArrayList<>();
            selecionadosP=new ArrayList<>();
    }
}