package co.edu.uniquindio.proyectobilletera.proyectobilletera.utils;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Billetera;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Usuario;

public class DataUtil {
    public static Billetera inicializarDatos() {
        Billetera billetera = new Billetera();
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

        return billetera;
    }
}
