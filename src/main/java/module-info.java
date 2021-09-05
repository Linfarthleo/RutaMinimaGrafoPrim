module com.example.rutaminima {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens rutaMinima to javafx.fxml;
    exports rutaMinima;
}