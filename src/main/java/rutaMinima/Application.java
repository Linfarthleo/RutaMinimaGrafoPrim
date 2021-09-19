package rutaMinima;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class Application extends javafx.application.Application {
    //atributos para arrastrar ventana
    private double xOffset;
    private double yOffset;
    //Metodo de inicialización de la interfaz gráfica anexado a view.fxml
    @Override
    public void start(Stage stage) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("view.fxml"));
        //evento en el moused pressed que permite mover cuando este presioando el mouse en cualquier parte del menu
        fxmlLoader.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        fxmlLoader.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX()-xOffset);
                stage.setY(event.getScreenY()- yOffset);
            }
        });

        //Características importantes de la intefaz padre, la cual contiene a las demas interfaces
        Scene scene = new Scene(fxmlLoader);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Rutas Mínimas - Grafos");
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
          launch();
    }
}