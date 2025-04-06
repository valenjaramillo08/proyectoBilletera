package co.edu.uniquindio.proyectobilletera.proyectobilletera;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BilleteraAplicacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BilleteraAplicacion.class.getResource("BilleteraApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Billetera Aplicacion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}