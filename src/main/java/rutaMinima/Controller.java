package rutaMinima;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            listaPaises=new Paises();
            cbPais.setItems(listaPaises.getCountries());
            selecionados=new ArrayList<>();


    }
}