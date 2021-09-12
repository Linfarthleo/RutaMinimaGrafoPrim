package rutaMinima;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Paises listaPaises;

    @FXML private ComboBox<String> cbPais;
    @FXML private ComboBox<String> cbCiudad;
    @FXML private Button btnInsertar;
    @FXML private TableView<String> tbCiudades;


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
        String str = cbCiudad.getValue();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            listaPaises=new Paises();
            cbPais.setItems(listaPaises.getCountries());


    }
}