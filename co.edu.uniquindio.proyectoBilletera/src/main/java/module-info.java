module co.edu.uniquindio.proyectobilletera.proyectobilletera {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires javafx.base;

    opens co.edu.uniquindio.proyectobilletera.proyectobilletera to javafx.fxml;
    exports co.edu.uniquindio.proyectobilletera.proyectobilletera;
    opens co.edu.uniquindio.proyectobilletera.proyectobilletera.viewcontroller;
    exports co.edu.uniquindio.proyectobilletera.proyectobilletera.viewcontroller;
    opens co.edu.uniquindio.proyectobilletera.proyectobilletera.controller;
    exports co.edu.uniquindio.proyectobilletera.proyectobilletera.controller;
   




}