package co.edu.uniquindio.proyectobilletera.proyectobilletera.utils;

import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Billetera;
import co.edu.uniquindio.proyectobilletera.proyectobilletera.model.Usuario;

public class DataUtil {
    public static Billetera inicializarDatos() {
        Billetera billetera = new Billetera();
        Usuario usuario1 = Usuario.builder()
                .telefono("31088873")
                .idUsuario("124535")
                .direccion("armenia")
                .saldoDisponible(Double.parseDouble("1.000.000"))
                .build();

        Usuario usuario2 = Usuario.builder()
                .telefono("31088873")
                .idUsuario("124535")
                .direccion("armenia")
                .saldoDisponible(Double.parseDouble("1.000.000"))
                .build();

        Usuario usuario3 = Usuario.builder()
                .telefono("31088873")
                .idUsuario("124535")
                .direccion("armenia")
                .saldoDisponible(Double.parseDouble("1.000.000"))
                .build();

        billetera.getListaUsuarios().add(usuario1);
        billetera.getListaUsuarios().add(usuario2);
        billetera.getListaUsuarios().add(usuario3);

        return billetera;
    }
}
