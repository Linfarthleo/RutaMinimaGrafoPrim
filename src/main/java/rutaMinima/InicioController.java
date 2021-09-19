package rutaMinima;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class InicioController {
    //atributos para arrastrar ventana
    private double xOffset;
    private double yOffset;
    //Cargar nueva ventana

    public void loadStage(String url, Event event){
        try{
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            Window window = oldScene.getWindow();
            Stage stage = (Stage) window;
            stage.hide();

            Parent root = FXMLLoader.load(getClass().getResource(url));
            //evento en el moused pressed que permite mover cuando este presioando el mouse en cualquier parte del menu


            //Características importantes de la intefaz padre, la cual contiene a las demas interfaces
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.setTitle("Calculadora de Rutas Mínimas Entre Ciudades");
            newStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icons8_world_map.png")));
            scene.setFill(Color.TRANSPARENT);
            newStage.setScene(scene);
            newStage.show();

            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    newStage.setX(event.getScreenX()-xOffset);
                    newStage.setY(event.getScreenY()- yOffset);
                }
            });
        }catch (IOException ex){
            System.out.println("Se ha producido el error: "+ex);
        }
    }

    public void onIngresarInicioClicked(MouseEvent event){
        loadStage("view.fxml", event);
    }

    //boton para salir, el cual genera un mensaje de alerta para confirmar que realmente se desea salir del programa
    public void onSalirButtonClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setContentText("¿Está seguro que desea salir?");
        alert.showAndWait();
        if (alert.getResult().equals(ButtonType.OK)) {
            Platform.exit();
            System.exit(0);
        }
    }
}
