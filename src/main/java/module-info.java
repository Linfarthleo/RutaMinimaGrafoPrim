module com.example.rutaminima {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens rutaMinima to javafx.fxml;
    exports rutaMinima;
}