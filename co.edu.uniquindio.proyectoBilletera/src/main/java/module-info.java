module co.edu.uniquindio.proyectobilletera.proyectobilletera {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquindio.proyectobilletera.proyectobilletera to javafx.fxml;
    exports co.edu.uniquindio.proyectobilletera.proyectobilletera;
}