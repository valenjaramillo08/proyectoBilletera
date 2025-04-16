package co.edu.uniquindio.proyectobilletera.proyectobilletera.utils;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Administrador;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Billetera;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.TipoCuenta;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Usuario;

public class DataUtil {
    public static Billetera inicializarDatos() {
        Billetera billetera = new Billetera();
        Administrador administrador = new Administrador("admin", "empleadp", "admin@gmail.com","12348");
        Usuario usuario1 = Usuario.builder()
                .nombre("Valentina")
                .apellido("Orozco")
                .idUsuario("12736")
                .correo("valentina@gmail.com")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Laura")
                .apellido("Bareño")
                .idUsuario("132324")
                .correo("laura@gmail.com")
                .build();

        Usuario usuario3 = Usuario.builder()
                .nombre("Mateo")
                .apellido("Toquica")
                .idUsuario("2223")
                .correo("mateo@gmail.com")
                .build();

        billetera.getListaUsuarios().add(usuario1);
        billetera.getListaUsuarios().add(usuario2);
        billetera.getListaUsuarios().add(usuario3);
        billetera.getListaAdministradores().add(administrador);
        billetera.agregarCuenta("567", "bogota", "889", TipoCuenta.AHORRO);

        return billetera;
    }
}
